package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.business.domain.read.models.CopyModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.CopyReadRepository;
import com.andurasoftware.alexandria.business.domain.write.aggregates.CopyAggregate;
import com.andurasoftware.alexandria.business.domain.write.repositories.base.CopyRepository;
import com.andurasoftware.alexandria.business.domain.write.states.CopyState;
import com.andurasoftware.alexandria.business.domain.write.states.TitleState;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class CopyController {

    @Autowired
    private CopyReadRepository copyReadRepository;

    @Autowired
    private CopyRepository copyRepository;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/copy/grid/list.json", method = RequestMethod.POST)
    public ResponseEntity<?> displayAll() {
        List<CopyModel> copyModelList = this.copyReadRepository.findAll();
        return ResponseEntity.ok(copyModelList);
    }

    @RequestMapping(value = "/api/copy/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody @NotNull CopyState copyState) {
        CopyAggregate copyAggregate = new CopyAggregate(copyState);
        this.copyRepository.save(copyAggregate);
        return ResponseEntity.ok(copyAggregate.getState());
    }

}
