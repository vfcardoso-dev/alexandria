package com.andurasoftware.alexandria.business.domain.write.repositories.base;

import com.andurasoftware.alexandria.business.domain.write.repositories.custom.AuthorRepositoryCustom;
import com.andurasoftware.alexandria.business.domain.write.states.AuthorState;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AuthorRepository extends CrudRepository<AuthorState, UUID>, AuthorRepositoryCustom {
}
