package com.andurasoftware.alexandria.business.security.write.repositories.custom;

import com.andurasoftware.alexandria.business.security.write.aggregates.AddressAggregate;

public interface AddressRepositoryCustom {
    void save(AddressAggregate aggregate);
}
