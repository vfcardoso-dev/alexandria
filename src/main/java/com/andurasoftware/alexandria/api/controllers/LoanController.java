package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.business.domain.read.models.grid.LoanGridViewModel;
import com.andurasoftware.alexandria.business.domain.read.models.grid.MemberGridModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.LoanGridReadRepository;
import com.andurasoftware.alexandria.business.domain.write.aggregates.LoanAggregate;
import com.andurasoftware.alexandria.business.domain.write.states.LoanState;
import com.andurasoftware.alexandria.business.domain.write.repositories.base.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

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

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/loan/get-by-id.json", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@RequestParam String id) {
        UUID uuid = UUID.fromString(id);
        LoanGridViewModel loanGridViewModel = this.loanGridReadRepository.getById(uuid);
        return ResponseEntity.ok(loanGridViewModel);
    }

}
