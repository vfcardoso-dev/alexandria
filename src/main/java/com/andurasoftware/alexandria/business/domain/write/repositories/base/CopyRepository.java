package com.andurasoftware.alexandria.business.domain.write.repositories.base;

import com.andurasoftware.alexandria.business.domain.write.repositories.custom.CopyRepositoryCustom;
import com.andurasoftware.alexandria.business.domain.write.states.CopyState;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CopyRepository extends CrudRepository<CopyState, UUID>, CopyRepositoryCustom {
}
