package com.andurasoftware.alexandria.business.domain.read.repositories.impl;

import com.andurasoftware.alexandria.business.domain.read.models.grid.LoanGridViewModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.base.LoanGridReadRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LoanGridReadRepositoryImpl implements LoanGridReadRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<LoanGridViewModel> findAll() {
        return this.em.createQuery("select m from LoanGridViewModel l", LoanGridViewModel.class).getResultList();
    }
}
