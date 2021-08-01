package com.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement
public class UserXMLForm {

    @JacksonXmlProperty(localName = "id")
    private String id;


    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "get")
    private List userCurrency; //

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "history")
    private List history;

    public List getHistory() {
        return history;
    }

    public void setHistory(List history) {
        this.history = history;
    }

    public List getUserCurrency() {
        return userCurrency;
    }

    public void setUserCurrency(List userCurrency) {
        this.userCurrency = userCurrency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
