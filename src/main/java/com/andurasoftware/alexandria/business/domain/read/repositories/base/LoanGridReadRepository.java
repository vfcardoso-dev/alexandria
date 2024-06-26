package com.andurasoftware.alexandria.business.domain.read.repositories.base;

import com.andurasoftware.alexandria.business.domain.read.models.grid.LoanGridViewModel;
import com.andurasoftware.alexandria.business.domain.read.repositories.custom.LoanGridReadRepositoryCustom;
import org.springframework.data.repository.Repository;


import java.util.UUID;

public interface LoanGridReadRepository extends Repository<LoanGridViewModel, UUID>, LoanGridReadRepositoryCustom {

}
