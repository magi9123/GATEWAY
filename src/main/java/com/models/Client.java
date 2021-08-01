package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

    @Id
    private String id;

    //other fields for the client


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
