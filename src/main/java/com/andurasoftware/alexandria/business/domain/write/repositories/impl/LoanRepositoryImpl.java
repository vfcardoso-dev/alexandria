package com.andurasoftware.alexandria.business.domain.write.repositories.impl;

import com.andurasoftware.alexandria.business.domain.write.aggregates.LoanAggregate;
import com.andurasoftware.alexandria.business.domain.write.repositories.custom.LoanRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LoanRepositoryImpl implements LoanRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(LoanAggregate loanAggregate) {
        this.em.persist(loanAggregate);
    }
}
