package com.models;

import java.util.Map;

public class FixerJSONFormat {

    private Boolean success;

    private Long timestamp;

    private String base;

    private String date;

    private Map<String, Double> rates;



    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
