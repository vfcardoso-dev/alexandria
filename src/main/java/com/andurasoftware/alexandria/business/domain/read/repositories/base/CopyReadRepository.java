package com.andurasoftware.alexandria.business.domain.read.repositories.base;

import com.andurasoftware.alexandria.business.domain.read.models.CopyModel;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface CopyReadRepository extends Repository<CopyModel, UUID>{

    //TODO: Abstrair
    List<CopyModel> findAll();
}
