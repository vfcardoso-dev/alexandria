package com.andurasoftware.alexandria.business.security.write.repositories.custom;

import com.andurasoftware.alexandria.business.security.write.aggregates.UserAggregate;

public interface UserRepositoryCustom {
    UserAggregate findByEmail(String email);
    void save(UserAggregate aggregate);
}
