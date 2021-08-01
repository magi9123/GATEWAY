package com.models.user;

import com.models.Client;
import com.models.Currency;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrimaryKeyJoinColumn;
import java.sql.Timestamp;

/**
 *
 * Common part for the tables user_currency and user_history_currency.
 * It is similar to table per class inheritance but no table joins or inheritance exists in data model.
 * There's no table for the mapped superclass. Inheritance only exists in object model.
 *
 */

@MappedSuperclass
public abstract class UserCurrencyAbstract {

    @Id
    private String requestId;

    private Long time;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "client", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "currency", referencedColumnName = "id")
    private Currency currency;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
