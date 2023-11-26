package com.andurasoftware.alexandria.business.domain.write.repositories.custom;

import com.andurasoftware.alexandria.business.domain.write.aggregates.LoanAggregate;

public interface LoanRepositoryCustom {
    void save(LoanAggregate loanAggregate);
}
