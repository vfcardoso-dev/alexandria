package com.andurasoftware.alexandria.business.domain.read.repositories.base;

import com.andurasoftware.alexandria.business.domain.read.models.grid.CopyGridModel;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface CopyGridReadRepository extends Repository<CopyGridModel, UUID> {

    List<CopyGridModel> findAll();
}
