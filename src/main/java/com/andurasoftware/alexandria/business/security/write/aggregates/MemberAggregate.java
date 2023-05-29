package com.andurasoftware.alexandria.business.security.write.aggregates;

import com.andurasoftware.alexandria.business.common.interfaces.BaseAggregate;
import com.andurasoftware.alexandria.business.security.write.states.MemberState;

public class MemberAggregate extends BaseAggregate<MemberState> {

    public MemberAggregate(MemberState state) {
        super(state);
    }
}
