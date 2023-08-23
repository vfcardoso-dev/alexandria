package com.andurasoftware.alexandria.business.domain.read.repositories.base;

import com.andurasoftware.alexandria.business.domain.read.models.grid.AuthorGridModel;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface AuthorGridReadRepository extends Repository<AuthorGridModel, UUID> {
    List<AuthorGridModel> findAll();
}
