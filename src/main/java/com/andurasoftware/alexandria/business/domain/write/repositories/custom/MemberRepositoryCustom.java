package com.andurasoftware.alexandria.business.domain.write.repositories.custom;

import com.andurasoftware.alexandria.business.domain.write.aggregates.MemberAggregate;

public interface MemberRepositoryCustom {
    void save(MemberAggregate memberAggregate);
}
