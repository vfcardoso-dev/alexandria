package com.andurasoftware.alexandria.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {



    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/payment/grid/list.json", method = RequestMethod.POST)
    public ResponseEntity<?> displayAll() {
        return ResponseEntity.ok("OK");
    }

}
