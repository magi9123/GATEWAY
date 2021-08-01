package com.controller;

import com.models.UserFormModel;
import com.services.UserCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(name = "/xml_api")
public class Provider2Controller {

    @Autowired
    private UserCurrencyService userCurrencyService;

    @PostMapping(value = "command", consumes = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public void user(@RequestBody UserFormModel user) {
        userCurrencyService.save(user);
    }
}
