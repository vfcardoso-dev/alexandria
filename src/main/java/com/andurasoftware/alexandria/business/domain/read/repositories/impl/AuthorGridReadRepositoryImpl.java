package com.andurasoftware.alexandria.business.domain.read.repositories.impl;

import com.andurasoftware.alexandria.business.domain.read.models.grid.AuthorGridModel;
import com.andurasoftware.alexandria.business.domain.read.models.grid.LoanGridViewModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.AuthorGridReadRepository;
import com.andurasoftware.alexandria.business.domain.read.repositories.custom.AuthorGridReadRepositoryCustom;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuthorGridReadRepositoryImpl implements AuthorGridReadRepositoryCustom {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<AuthorGridModel> findAll() {
        return this.em.createQuery("select u from AuthorGridModel u join r.titleSet t", AuthorGridModel.class).getResultList();
    }

    @Override
    public AuthorGridModel getById(UUID id) {
        TypedQuery<AuthorGridModel> query = em.createQuery("select a from AuthorGridModel a where a.id = :id", AuthorGridModel.class);
        AuthorGridModel authorGridModel = query.setParameter("id", id).getSingleResult();
        return authorGridModel;
    }
}
