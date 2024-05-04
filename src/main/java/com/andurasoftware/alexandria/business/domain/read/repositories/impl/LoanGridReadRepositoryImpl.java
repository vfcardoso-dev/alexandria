package com.andurasoftware.alexandria.business.domain.read.repositories.impl;

import com.andurasoftware.alexandria.business.domain.read.models.grid.LoanGridViewModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.custom.LoanGridReadRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class LoanGridReadRepositoryImpl implements LoanGridReadRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<LoanGridViewModel> findAll() {
        return this.em.createQuery("select l from LoanGridViewModel l", LoanGridViewModel.class).getResultList();
    }

    @Override
    public LoanGridViewModel getById(UUID id) {
        TypedQuery<LoanGridViewModel> query = em.createQuery("select l from LoanGridViewModel l where l.id = :id", LoanGridViewModel.class);
        LoanGridViewModel loanGridView = query.setParameter("id", id).getSingleResult();
        return loanGridView;
    }


}
