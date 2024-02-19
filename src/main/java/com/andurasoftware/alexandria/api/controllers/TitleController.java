package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.business.domain.read.models.TitleModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.TitleReadRepository;
import com.andurasoftware.alexandria.business.domain.write.aggregates.AuthorAggregate;
import com.andurasoftware.alexandria.business.domain.write.aggregates.TitleAggregate;
import com.andurasoftware.alexandria.business.domain.write.repositories.base.TitleRepository;
import com.andurasoftware.alexandria.business.domain.write.states.AuthorState;
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
public class TitleController {

    @Autowired
    private TitleReadRepository titleReadRepository;

    @Autowired
    private TitleRepository titleRepository;


    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/title/grid/list.json", method = RequestMethod.POST)
    public ResponseEntity<?> displayAll() {
        List<TitleModel> titleModelList = this.titleReadRepository.findAll();
        return ResponseEntity.ok(titleModelList);
    }

    @RequestMapping(value = "/api/title/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody @NotNull TitleState titleState) {
        titleState.setVersion(new Date());
        TitleAggregate titleAggregate = new TitleAggregate(titleState);
        this.titleRepository.save(titleAggregate);
        return ResponseEntity.ok(titleAggregate.getState());
    }

}
