package com.andurasoftware.alexandria.business.security.read.repositories.impl;

import com.andurasoftware.alexandria.business.security.read.models.UserGridModel;
import com.andurasoftware.alexandria.business.security.read.repositories.base.UserGridReadRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserGridReadRepositoryImpl implements UserGridReadRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UserGridModel> findAll() {
        List<UserGridModel> userModelList = this.em.createQuery("select u from UserDisplayModel u", UserGridModel.class).getResultList();
        return userModelList;
    }
}
