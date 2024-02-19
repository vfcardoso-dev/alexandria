package com.andurasoftware.alexandria.business.domain.write.aggregates;

import com.andurasoftware.alexandria.business.common.interfaces.BaseAggregate;
import com.andurasoftware.alexandria.business.domain.write.states.TitleState;


public class TitleAggregate extends BaseAggregate<TitleState> {
    public TitleAggregate(TitleState state) {
        super(state);
    }
}
