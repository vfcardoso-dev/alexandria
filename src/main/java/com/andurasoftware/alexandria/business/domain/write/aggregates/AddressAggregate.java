package com.andurasoftware.alexandria.business.domain.write.aggregates;

import com.andurasoftware.alexandria.business.common.interfaces.BaseAggregate;
import com.andurasoftware.alexandria.business.domain.write.states.AddressState;

public class AddressAggregate extends BaseAggregate<AddressState> {
    public AddressAggregate(AddressState state) {
        super(state);
    }
}
