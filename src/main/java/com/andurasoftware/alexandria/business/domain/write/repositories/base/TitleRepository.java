package com.andurasoftware.alexandria.business.domain.write.repositories.base;

import com.andurasoftware.alexandria.business.domain.write.repositories.custom.TitleRepositoryCustom;
import com.andurasoftware.alexandria.business.domain.write.states.TitleState;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TitleRepository extends CrudRepository<TitleState, UUID>, TitleRepositoryCustom {
}
