package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.business.security.read.models.AuthorGridModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.AuthorGridReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorGridReadRepository authorGridReadRepository;


    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/author/grid/list.json", method = RequestMethod.POST)
    public ResponseEntity<?> displayAll() {
        List<AuthorGridModel> userModelList = this.authorGridReadRepository.findAll();
        return ResponseEntity.ok(userModelList);
    }

}
