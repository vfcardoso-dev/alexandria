package com.andurasoftware.alexandria.business.domain.write.repositories.base;

import com.andurasoftware.alexandria.business.domain.write.repositories.custom.MemberRepositoryCustom;
import com.andurasoftware.alexandria.business.domain.write.states.AuthorState;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MemberRepository extends CrudRepository<AuthorState, UUID>, MemberRepositoryCustom {
}
