package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.business.domain.read.models.grid.AuthorGridModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.AuthorGridReadRepository;
import com.andurasoftware.alexandria.business.domain.write.aggregates.AuthorAggregate;
import com.andurasoftware.alexandria.business.domain.write.repositories.base.AuthorRepository;
import com.andurasoftware.alexandria.business.domain.write.states.AuthorState;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AuthorController {

    @Autowired
    private AuthorGridReadRepository authorGridReadRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/author/grid/list.json", method = RequestMethod.POST)
    public ResponseEntity<?> displayAll() {
        List<AuthorGridModel> userModelList = this.authorGridReadRepository.findAll();
        return ResponseEntity.ok(userModelList);
    }

    @RequestMapping(value = "/api/author/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody @NotNull AuthorState authorState) {
        authorState.setVersion(new Date());
        AuthorAggregate authorAggregate = new AuthorAggregate(authorState);
        this.authorRepository.save(authorAggregate);
        return ResponseEntity.ok(authorAggregate.getState());
    }


    @RequestMapping(value = "/api/author/update", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody @NotNull AuthorState authorState) {
        authorState.setVersion(new Date());
        Optional<AuthorState> opt = this.authorRepository.findById(authorState.getId());
        if(opt.isEmpty()){
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
        AuthorAggregate authorAggregate = new AuthorAggregate(opt.get());
        authorAggregate.update(authorState);
        this.authorRepository.save(authorAggregate);
        return ResponseEntity.ok(authorAggregate.getState());
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/author/get-by-id", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@RequestParam String id) {
        UUID uuid = UUID.fromString(id);
        AuthorGridModel model = this.authorGridReadRepository.findById(uuid);
        return ResponseEntity.ok(model);
    }

}
