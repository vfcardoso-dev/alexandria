package com.andurasoftware.alexandria.business.security.write.repositories.base;

import com.andurasoftware.alexandria.business.domain.write.states.LoanState;
import com.andurasoftware.alexandria.business.security.write.repositories.custom.LoanRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LoanRepository extends CrudRepository<LoanState, UUID>, LoanRepositoryCustom {

}
