package com.andurasoftware.alexandria.business.domain.read.repositories.impl;

import com.andurasoftware.alexandria.business.domain.read.models.grid.AuthorGridModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.AuthorGridReadRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AuthorGridReadRepositoryImpl implements AuthorGridReadRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<AuthorGridModel> findAll() {
        return this.em.createQuery("select u from AuthorGridModel u", AuthorGridModel.class).getResultList();
    }
}
