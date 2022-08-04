package com.andurasoftware.alexandria.business.security.write.aggregates;

import com.andurasoftware.alexandria.business.common.interfaces.BaseAggregate;
import com.andurasoftware.alexandria.business.security.write.states.UserState;

public class UserAggregate extends BaseAggregate<UserState> {

    public UserAggregate(UserState state) {
        super(state);
    }
}
