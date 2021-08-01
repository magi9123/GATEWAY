package com.models.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_history_currency")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "requestId", scope = UserCurrencyHistory.class)
public class UserCurrencyHistory extends UserCurrencyAbstract {

    private int period;

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
