package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.api.models.StringWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(new StringWrapper("Ahoy!"));
    }
}
