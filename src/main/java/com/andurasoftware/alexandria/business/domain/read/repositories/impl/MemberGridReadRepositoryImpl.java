package com.andurasoftware.alexandria.business.domain.read.repositories.impl;

import com.andurasoftware.alexandria.business.domain.read.models.grid.MemberGridModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.MemberGridReadRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class MemberGridReadRepositoryImpl implements MemberGridReadRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MemberGridModel> findAll() {
        return this.em.createQuery("select m from MemberGridModel m", MemberGridModel.class).getResultList();
    }
}
