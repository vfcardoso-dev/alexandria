package com.andurasoftware.alexandria.business.domain.write.aggregates;

import com.andurasoftware.alexandria.business.common.interfaces.BaseAggregate;
import com.andurasoftware.alexandria.business.domain.write.states.AuthorState;

import java.util.UUID;

public class AuthorAggregate extends BaseAggregate<AuthorState> {

    public AuthorAggregate(AuthorState state) {
        super(state);
        if(state.getId() == null){
            state.setId(UUID.randomUUID());
        }
    }
}
