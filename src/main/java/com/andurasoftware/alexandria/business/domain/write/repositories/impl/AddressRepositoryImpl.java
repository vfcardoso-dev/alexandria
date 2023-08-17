package com.andurasoftware.alexandria.business.domain.write.repositories.impl;

import com.andurasoftware.alexandria.business.domain.write.aggregates.AddressAggregate;
import com.andurasoftware.alexandria.business.domain.write.repositories.custom.AddressRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AddressRepositoryImpl implements AddressRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(AddressAggregate aggregate) {
        this.em.persist(aggregate.getState());
    }
}
