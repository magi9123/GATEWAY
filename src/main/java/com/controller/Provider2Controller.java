package com.controller;

import com.models.UserFormModel;
import com.models.UserXMLForm;
import com.services.RabbitMqSender;
import com.services.UserCurrencyService;
import com.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(name = "/xml_api")
public class Provider2Controller {

    public static final String RECORD_IS_SAVED = "RECORD_IS_SAVED";

    @Autowired
    private UserCurrencyService userCurrencyService;

    @Autowired
    private RabbitMqSender rabbitMqSender;

    @PostMapping(value = "/command")
    public ResponseEntity<Response> userCurrent(@RequestBody UserXMLForm user) {
        UserFormModel userFormModel = new UserFormModel();
        userFormModel = userFormModel.convertXMLFormToUserForm(user);
        userCurrencyService.save(userFormModel);

        rabbitMqSender.send(userFormModel);

        List<String> details = new ArrayList<>();
        details.add(userFormModel.getRequestId());
        Response response = new Response(RECORD_IS_SAVED, details);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
