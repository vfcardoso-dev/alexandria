package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.api.models.JwtRequest;
import com.andurasoftware.alexandria.api.models.JwtResponse;
import com.andurasoftware.alexandria.business.security.read.models.UserModel;
import com.andurasoftware.alexandria.business.security.read.repositories.base.UserReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserReadRepository userReadRepository;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/user/list-all", method = RequestMethod.POST)
    public ResponseEntity<?> listAll() throws Exception {
        List<UserModel> userModelList = this.userReadRepository.findAll();
        return ResponseEntity.ok(userModelList);
    }
}
