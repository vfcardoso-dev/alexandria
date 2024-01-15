package com.andurasoftware.alexandria.business.domain.write.repositories.custom;

import com.andurasoftware.alexandria.business.domain.write.aggregates.AuthorAggregate;

public interface AuthorRepositoryCustom {
    void save(AuthorAggregate authorAggregate);
}
