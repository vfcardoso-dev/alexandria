package com.andurasoftware.alexandria.business.domain.read.repositories.impl;

import com.andurasoftware.alexandria.business.domain.read.models.grid.AuthorGridModel;
import com.andurasoftware.alexandria.business.domain.read.models.grid.CopyGridModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.CopyGridReadRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CopyGridReadRepositoryImpl implements CopyGridReadRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CopyGridModel> findAll() {
        return this.em.createQuery("select c from CopyGridModel c join u.titleModel t", CopyGridModel.class).getResultList();
    }
}
