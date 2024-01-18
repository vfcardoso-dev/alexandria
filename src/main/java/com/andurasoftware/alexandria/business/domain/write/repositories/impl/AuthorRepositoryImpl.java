package com.andurasoftware.alexandria.business.domain.write.repositories.impl;


import com.andurasoftware.alexandria.business.domain.write.aggregates.AuthorAggregate;
import com.andurasoftware.alexandria.business.domain.write.repositories.custom.AuthorRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(AuthorAggregate authorAggregate) {
        this.em.persist(authorAggregate.getState());
    }
}
