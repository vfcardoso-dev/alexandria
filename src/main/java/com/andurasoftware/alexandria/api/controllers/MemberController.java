package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.business.domain.read.models.grid.MemberGridModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.MemberGridReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberGridReadRepository memberGridReadRepository;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/member/grid/list.json", method = RequestMethod.POST)
    public ResponseEntity<?> displayAll() {
        List<MemberGridModel> memberGridModelList = this.memberGridReadRepository.findAll();
        return ResponseEntity.ok(memberGridModelList);
    }
}
