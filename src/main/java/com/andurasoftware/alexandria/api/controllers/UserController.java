package com.andurasoftware.alexandria.api.controllers;

import com.andurasoftware.alexandria.business.security.read.models.UserGridModel;
import com.andurasoftware.alexandria.business.security.read.models.UserModel;
import com.andurasoftware.alexandria.business.security.read.repositories.base.UserGridReadRepository;
import com.andurasoftware.alexandria.business.security.read.repositories.base.UserReadRepository;
import com.andurasoftware.alexandria.business.security.shared.valueobjects.SecurityRole;
import com.andurasoftware.alexandria.business.security.write.aggregates.UserAggregate;
import com.andurasoftware.alexandria.business.security.write.repositories.base.UserRepository;
import com.andurasoftware.alexandria.business.security.write.states.UserState;
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
public class UserController {


    @Autowired
    UserReadRepository userReadRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserGridReadRepository userGridReadRepository;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/user/list-all", method = RequestMethod.POST)
    public ResponseEntity<?> listAll() throws Exception {
        List<UserModel> userModelList = this.userReadRepository.findAll();
        return ResponseEntity.ok(userModelList);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/user/grid/list.json", method = RequestMethod.POST)
    public ResponseEntity<?> displayAll() throws Exception {
        List<UserGridModel> userModelList = this.userGridReadRepository.findAll();
        return ResponseEntity.ok(userModelList);
    }


    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/api/user/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody UserState userState) throws Exception {
        userState.setCreatedAt(new Date());
        userState.setRole(SecurityRole.USER);
        UserAggregate userAggregate = new UserAggregate(userState);
        this.userRepository.save(userAggregate.getState());
        return ResponseEntity.ok(userAggregate.getState());
    }
}
