package com.andurasoftware.alexandria.business.domain.write.repositories.impl;

import com.andurasoftware.alexandria.business.domain.write.aggregates.CopyAggregate;
import com.andurasoftware.alexandria.business.domain.write.repositories.custom.CopyRepositoryCustom;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CopyRepositoryImpl implements CopyRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(CopyAggregate copyAggregate) {
        copyAggregate.setVersionToNow();
        this.em.persist(copyAggregate.getState());
    }
}
