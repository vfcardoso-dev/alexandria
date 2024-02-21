package com.andurasoftware.alexandria.business.domain.write.repositories.custom;

import com.andurasoftware.alexandria.business.domain.write.aggregates.CopyAggregate;

public interface CopyRepositoryCustom {
    void save(CopyAggregate copyAggregate);
}
