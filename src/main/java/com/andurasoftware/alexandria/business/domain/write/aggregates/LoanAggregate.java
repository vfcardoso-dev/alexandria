package com.andurasoftware.alexandria.business.domain.write.aggregates;

import com.andurasoftware.alexandria.business.common.interfaces.BaseAggregate;
import com.andurasoftware.alexandria.business.domain.write.states.LoanState;

import java.util.Calendar;
import java.util.UUID;

public class LoanAggregate extends BaseAggregate<LoanState> {

    public LoanAggregate(LoanState state) {
        super(state);
        this.setExpiringDate();
    }

    private void setExpiringDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(state.getDate());
        calendar.add(Calendar.DATE,7);
        state.setExpiringDate(calendar.getTime());
    }
}
