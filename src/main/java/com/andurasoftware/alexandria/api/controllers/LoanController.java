package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.business.domain.read.models.grid.LoanGridViewModel;
import com.andurasoftware.alexandria.business.domain.read.models.grid.MemberGridModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.LoanGridReadRepository;
import com.andurasoftware.alexandria.business.domain.write.aggregates.LoanAggregate;
import com.andurasoftware.alexandria.business.domain.write.states.LoanState;
import com.andurasoftware.alexandria.business.domain.write.repositories.base.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
    LoanRepository loanRepository;
    @Autowired
    LoanGridReadRepository loanGridReadRepository;

    @RequestMapping(value = "/api/loan/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody LoanState loanState) {
        LoanAggregate loanAggregate = new LoanAggregate(loanState);
        this.loanRepository.save(loanAggregate.getState());
        return ResponseEntity.ok(loanAggregate.getState());
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/loan/grid/list.json", method = RequestMethod.POST)
    public ResponseEntity<?> displayAll() {
        List<LoanGridViewModel> loanGridViewModelList = this.loanGridReadRepository.findAll();
        return ResponseEntity.ok(loanGridViewModelList);
    }

}
