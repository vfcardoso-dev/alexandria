package com.andurasoftware.alexandria.business.domain.write.repositories.impl;

import com.andurasoftware.alexandria.business.domain.write.aggregates.TitleAggregate;
import com.andurasoftware.alexandria.business.domain.write.repositories.custom.TitleRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class TitleRepositoryImpl implements TitleRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(TitleAggregate titleAggregate) {
        this.em.persist(titleAggregate.getState());
    }
}
