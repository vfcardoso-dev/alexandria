package com.andurasoftware.alexandria.business.domain.read.repositories.custom;

import com.andurasoftware.alexandria.business.domain.read.models.grid.LoanGridViewModel;

import java.util.List;
import java.util.UUID;

public interface LoanGridReadRepositoryCustom {
    List<LoanGridViewModel> findAll();
    LoanGridViewModel getById(UUID id);
}
