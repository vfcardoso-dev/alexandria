package com.andurasoftware.alexandria.business.domain.write.repositories.custom;

import com.andurasoftware.alexandria.business.domain.write.aggregates.AddressAggregate;

public interface AddressRepositoryCustom {
    void save(AddressAggregate aggregate);
}
