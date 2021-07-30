package com.controller;

import com.models.user.UserAbstract;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Provider2Controller {

    @PostMapping(consumes = MediaType.APPLICATION_ATOM_XML_VALUE)
    public void user(@RequestBody UserAbstract userAbstract) {

    }
}
