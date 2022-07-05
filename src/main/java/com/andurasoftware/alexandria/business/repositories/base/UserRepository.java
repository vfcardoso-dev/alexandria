package com.andurasoftware.alexandria.business.repositories.base;

import com.andurasoftware.alexandria.business.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User save(User user);
}
