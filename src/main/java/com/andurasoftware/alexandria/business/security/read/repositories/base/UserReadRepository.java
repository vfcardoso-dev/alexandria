package com.andurasoftware.alexandria.business.security.read.repositories.base;

import com.andurasoftware.alexandria.business.security.read.models.UserModel;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserReadRepository extends Repository<UserModel, UUID> {
    Optional<UserModel> findById(UUID id);
    Optional<UserModel> findByEmail(String email);
    List<UserModel> findAll();

}