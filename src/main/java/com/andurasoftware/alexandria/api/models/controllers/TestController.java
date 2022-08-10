package com.andurasoftware.alexandria.api.models.controllers;

import com.andurasoftware.alexandria.business.infra.wrappers.StringWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    @ResponseBody
    public StringWrapper test() {
        return new StringWrapper("Ahoy!");
    }
}
