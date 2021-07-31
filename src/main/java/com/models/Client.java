package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Table(name = "client")
public class Client {

    @Id
    private String id;

    //other data to the client


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
