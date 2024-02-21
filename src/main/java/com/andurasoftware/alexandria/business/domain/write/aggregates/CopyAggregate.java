package com.andurasoftware.alexandria.business.domain.write.aggregates;

import com.andurasoftware.alexandria.business.common.interfaces.BaseAggregate;
import com.andurasoftware.alexandria.business.domain.write.states.CopyState;

import java.util.Date;

public class CopyAggregate extends BaseAggregate<CopyState> {

    public CopyAggregate(CopyState state) {
        super(state);
    }

    public void setVersionToNow(){
        this.state.setVersion(new Date());
    }
}
