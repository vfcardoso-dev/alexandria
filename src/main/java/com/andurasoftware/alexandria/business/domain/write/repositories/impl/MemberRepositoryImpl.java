package com.andurasoftware.alexandria.business.domain.write.repositories.impl;

import com.andurasoftware.alexandria.business.domain.write.aggregates.AuthorAggregate;
import com.andurasoftware.alexandria.business.domain.write.aggregates.MemberAggregate;
import com.andurasoftware.alexandria.business.domain.write.repositories.custom.MemberRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(MemberAggregate memberAggregate) {
        this.em.persist(memberAggregate.getState());
    }
}
