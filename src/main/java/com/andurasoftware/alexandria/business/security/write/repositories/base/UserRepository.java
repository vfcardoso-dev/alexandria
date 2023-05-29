package com.andurasoftware.alexandria.business.security.write.repositories.base;

import com.andurasoftware.alexandria.business.security.write.repositories.custom.UserRepositoryCustom;
import com.andurasoftware.alexandria.business.security.write.states.UserState;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserState, UUID>, UserRepositoryCustom {
}
