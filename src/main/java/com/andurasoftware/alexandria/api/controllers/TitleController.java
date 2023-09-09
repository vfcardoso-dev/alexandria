package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.business.domain.read.models.TitleModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.TitleReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TitleController {

    @Autowired
    private TitleReadRepository titleReadRepository;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/title/grid/list.json", method = RequestMethod.POST)
    public ResponseEntity<?> displayAll() {
        List<TitleModel> titleModelList = this.titleReadRepository.findAll();
        return ResponseEntity.ok(titleModelList);
    }

}
