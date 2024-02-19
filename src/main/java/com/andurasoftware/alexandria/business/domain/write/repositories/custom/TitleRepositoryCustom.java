package com.andurasoftware.alexandria.business.domain.write.repositories.custom;

import com.andurasoftware.alexandria.business.domain.write.aggregates.TitleAggregate;

public interface TitleRepositoryCustom {
    void save(TitleAggregate titleAggregate);
}
