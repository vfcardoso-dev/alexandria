package com.andurasoftware.alexandria.business.domain.read.repositories.base;

import com.andurasoftware.alexandria.business.domain.read.models.grid.MemberGridModel;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface MemberGridReadRepository extends Repository<MemberGridModel, UUID> {
    List<MemberGridModel> findAll();
}
