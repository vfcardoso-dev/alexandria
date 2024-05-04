package com.andurasoftware.alexandria.business.domain.read.repositories.base;

import com.andurasoftware.alexandria.business.domain.read.models.grid.LoanGridViewModel;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface LoanReadRepository extends Repository <LoanGridViewModel, UUID> {

}
