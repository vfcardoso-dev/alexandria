package com.andurasoftware.alexandria.business.domain.write.repositories.impl;

import com.andurasoftware.alexandria.business.domain.write.aggregates.CopyAggregate;
import com.andurasoftware.alexandria.business.domain.write.repositories.custom.CopyRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class CopyRepositoryImpl implements CopyRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(CopyAggregate copyAggregate) {
        copyAggregate.setVersionToNow();
        this.em.persist(copyAggregate);
    }
}
