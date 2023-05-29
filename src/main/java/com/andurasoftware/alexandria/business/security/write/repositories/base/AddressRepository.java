package com.andurasoftware.alexandria.business.security.write.repositories.base;

import com.andurasoftware.alexandria.business.security.write.states.AddressState;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<AddressState, UUID>{
}
