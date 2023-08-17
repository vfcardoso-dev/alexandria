package com.andurasoftware.alexandria.business.domain.write.repositories.base;

import com.andurasoftware.alexandria.business.domain.write.states.AddressState;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<AddressState, UUID>{
}
