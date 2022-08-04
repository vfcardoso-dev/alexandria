package com.andurasoftware.alexandria.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    public String test() {

        return "Ahoy!";
    }
}
