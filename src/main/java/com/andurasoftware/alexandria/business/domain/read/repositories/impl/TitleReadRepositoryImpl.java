package com.andurasoftware.alexandria.business.domain.read.repositories.impl;

import com.andurasoftware.alexandria.business.domain.read.models.TitleModel;
import com.andurasoftware.alexandria.business.domain.read.models.grid.AuthorGridModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.TitleReadRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TitleReadRepositoryImpl implements TitleReadRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<TitleModel> findAll() {
        return this.em.createQuery("select t from TitleModel t", TitleModel.class).getResultList();
    }
}
