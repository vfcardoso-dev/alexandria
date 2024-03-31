package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.business.domain.read.models.grid.MemberGridModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.MemberGridReadRepository;
import com.andurasoftware.alexandria.business.domain.write.aggregates.MemberAggregate;
import com.andurasoftware.alexandria.business.domain.write.repositories.base.MemberRepository;
import com.andurasoftware.alexandria.business.domain.write.states.AuthorState;
import com.andurasoftware.alexandria.business.domain.write.states.MemberState;
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
public class MemberController {

    @Autowired
    private MemberGridReadRepository memberGridReadRepository;

    @Autowired
    private MemberRepository memberRepository;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/member/grid/list.json", method = RequestMethod.POST)
    public ResponseEntity<?> displayAll() {
        List<MemberGridModel> memberGridModelList = this.memberGridReadRepository.findAll();
        return ResponseEntity.ok(memberGridModelList);
    }

    @RequestMapping(value = "/api/member/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody @NotNull MemberState memberState) {
        memberState.setVersion(new Date());
        MemberAggregate memberAggregate = new MemberAggregate(memberState);
        this.memberRepository.save(memberAggregate);
        return ResponseEntity.ok(memberAggregate.getState());
    }
}
