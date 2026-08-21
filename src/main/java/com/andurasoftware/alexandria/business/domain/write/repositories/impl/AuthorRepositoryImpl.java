package com.andurasoftware.alexandria.business.domain.write.repositories.impl;


import com.andurasoftware.alexandria.business.domain.write.aggregates.AuthorAggregate;
import com.andurasoftware.alexandria.business.domain.write.repositories.custom.AuthorRepositoryCustom;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

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
