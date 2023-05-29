package com.andurasoftware.alexandria.business.security.write.repositories.impl;

import com.andurasoftware.alexandria.business.security.write.aggregates.UserAggregate;
import com.andurasoftware.alexandria.business.security.write.repositories.custom.UserRepositoryCustom;
import com.andurasoftware.alexandria.business.security.write.states.UserState;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserAggregate findByEmail(String email) {
        try {
            UserState state = this.em.createQuery("select u from UserState u where u.email = :email", UserState.class)
                    .setParameter("email", email)
                    .getSingleResult();

            return new UserAggregate(state);
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(UserAggregate aggregate) {
        this.em.persist(aggregate.getState());
    }

}
