package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.business.domain.write.aggregates.LoanAggregate;
import com.andurasoftware.alexandria.business.domain.write.states.LoanState;
import com.andurasoftware.alexandria.business.security.write.repositories.base.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoanController {

    @Autowired
    LoanRepository loanRepository;

    @RequestMapping(value = "/api/load/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody LoanState loanState) {
        LoanAggregate loanAggregate = new LoanAggregate(loanState);
        this.loanRepository.save(loanAggregate.getState());
        return ResponseEntity.ok(loanAggregate.getState());
    }

}
