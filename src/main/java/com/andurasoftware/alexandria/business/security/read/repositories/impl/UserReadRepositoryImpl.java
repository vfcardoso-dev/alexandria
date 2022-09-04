package com.andurasoftware.alexandria.business.security.read.repositories.impl;

import com.andurasoftware.alexandria.business.security.read.models.UserModel;
import com.andurasoftware.alexandria.business.security.read.repositories.base.UserReadRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserReadRepositoryImpl implements UserReadRepository {


    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<UserModel> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserModel> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<UserModel> findAll() {
        List<UserModel> userModelList = this.em.createQuery("select u from UserModel u",UserModel.class).getResultList();
        return userModelList;
    }

}
