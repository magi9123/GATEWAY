package com.models.user;

import com.models.Client;
import com.models.Currency;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrimaryKeyJoinColumn;
import java.sql.Timestamp;

@MappedSuperclass
public class UserAbstract {

    private String requestId;

    private Timestamp time;

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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
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
