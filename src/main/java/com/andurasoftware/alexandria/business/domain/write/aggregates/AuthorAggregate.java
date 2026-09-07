package com.andurasoftware.alexandria.business.domain.write.aggregates;

import com.andurasoftware.alexandria.business.common.interfaces.BaseAggregate;
import com.andurasoftware.alexandria.business.domain.write.states.AuthorState;

import java.time.LocalDateTime;

public class AuthorAggregate extends BaseAggregate<AuthorState> {

    public AuthorAggregate(AuthorState state) {
        super(state);
    }

    public void update(AuthorState newState){
        state.setName(newState.getName());
        state.setLastName(newState.getLastName());
        state.setPseudonym(newState.getPseudonym());
        state.setVersion(LocalDateTime.now());
    }
}
