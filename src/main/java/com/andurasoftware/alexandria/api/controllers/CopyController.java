package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.business.domain.read.models.CopyModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.CopyReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CopyController {

    @Autowired
    private CopyReadRepository copyReadRepository;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/copy/grid/list.json", method = RequestMethod.POST)
    public ResponseEntity<?> displayAll() {
        List<CopyModel> copyModelList = this.copyReadRepository.findAll();
        return ResponseEntity.ok(copyModelList);
    }

}
