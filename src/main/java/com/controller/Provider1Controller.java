package com.controller;

import com.models.user.UserAbstract;
import com.services.RabbitMqSender;
import com.services.UserCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json_api")
public class Provider1Controller {

    @Autowired
    private UserCurrencyService userCurrencyService;

    @Autowired
    private RabbitMqSender rabbitMqSender;

    @PostMapping(value = "/current", consumes = "application/json")
    public void currentUser(@RequestBody UserAbstract userAbstract) {
        userCurrencyService.save(userAbstract);
        rabbitMqSender.send(userAbstract);
    }

    @PostMapping(value = "/history", consumes = "application/json")
    public void userHistory(@RequestBody UserAbstract userAbstract) {
        userCurrencyService.save(userAbstract);
    }
}
