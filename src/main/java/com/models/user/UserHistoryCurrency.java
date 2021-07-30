package com.models.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_history_currency")
public class UserHistoryCurrency extends UserAbstract {

    private int period;

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
