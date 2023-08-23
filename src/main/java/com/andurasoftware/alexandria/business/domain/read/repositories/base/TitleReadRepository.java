package com.andurasoftware.alexandria.business.domain.read.repositories.base;

import com.andurasoftware.alexandria.business.domain.read.models.TitleModel;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface TitleReadRepository extends Repository<TitleModel, UUID> {
    List<TitleModel> findAll();
}
