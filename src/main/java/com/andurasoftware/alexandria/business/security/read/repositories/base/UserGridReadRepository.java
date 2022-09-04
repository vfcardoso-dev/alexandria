package com.andurasoftware.alexandria.business.security.read.repositories.base;

import com.andurasoftware.alexandria.business.security.read.models.UserGridModel;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface UserGridReadRepository extends Repository<UserGridModel, UUID> {
    public List<UserGridModel> findAll();
}
