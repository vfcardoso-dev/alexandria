package com.andurasoftware.alexandria.business.domain.read.repositories.base;

import com.andurasoftware.alexandria.business.domain.read.models.grid.LoanGridViewModel;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface LoanGridReadRepository extends Repository<LoanGridViewModel, UUID> {
    List<LoanGridViewModel> findAll();
}
