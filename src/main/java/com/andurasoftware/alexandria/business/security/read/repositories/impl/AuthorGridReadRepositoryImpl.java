package com.andurasoftware.alexandria.business.security.read.repositories.impl;

import com.andurasoftware.alexandria.business.security.read.models.AuthorGridModel;
import com.andurasoftware.alexandria.business.security.read.repositories.base.AuthorGridReadRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AuthorGridReadRepositoryImpl implements AuthorGridReadRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<AuthorGridModel> findAll() {
        List<AuthorGridModel> authorModelList = this.em.createQuery("select u from AuthorGridModel u", AuthorGridModel.class).getResultList();
        return authorModelList;
    }
}
