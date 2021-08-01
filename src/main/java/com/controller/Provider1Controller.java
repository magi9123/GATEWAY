package com.controller;

import com.utils.Response;
import com.models.UserFormModel;
import com.services.RabbitMqSender;
import com.services.UserCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/json_api")
public class Provider1Controller {

    public static final String RECORD_IS_SAVED = "RECORD_IS_SAVED";

    @Autowired
    private UserCurrencyService userCurrencyService;

    @Autowired
    private RabbitMqSender rabbitMqSender;

    @PostMapping(value = "/current", consumes = "application/json")
    public ResponseEntity<Response> currentUser(@RequestBody UserFormModel user) {
        userCurrencyService.save(user);
        rabbitMqSender.send(user);

        List<String> details = new ArrayList<>();
        details.add(user.getRequestId());
        Response response = new Response(RECORD_IS_SAVED, details);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/history", consumes = "application/json")
    public ResponseEntity<Response> userHistory(@RequestBody UserFormModel user) {
        userCurrencyService.save(user);
        rabbitMqSender.send(user);

        List<String> details = new ArrayList<>();
        details.add(user.getRequestId());
        Response response = new Response(RECORD_IS_SAVED, details);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
