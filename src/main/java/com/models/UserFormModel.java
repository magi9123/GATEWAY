package com.models;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Form model for extracting data from json request
 * and mapping data from UserXMLForm class to data standardization
 *
 * @version 1.0
 */
public class UserFormModel {

    private String requestId;
    private Long timestamp;
    private String client;
    private String currency;
    private int period;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }


    /**
     *
     * Mapping xml request to UserFormModel.class
     *
     * @param userXMLForm
     * @return UserFormModel
     */
    public UserFormModel convertXMLFormToUserForm(UserXMLForm userXMLForm) {
        UserFormModel user = new UserFormModel();
        user.setRequestId(userXMLForm.getId());

        List<LinkedHashMap> listJSON = userXMLForm.getUserCurrency();
        if (listJSON != null) {
            for (int i = 0; i < listJSON.size(); i++) {
                Map<String, String> properties = listJSON.get(i);

                for (Map.Entry<String, String> values : properties.entrySet()) {
                    if (values.getKey().equalsIgnoreCase("consumer")) {
                        user.setClient(values.getValue());
                    }

                    if (values.getKey().equalsIgnoreCase("currency")) {
                        user.setCurrency(values.getValue());
                    }
                }
            }
        }

        listJSON = null;

        listJSON = userXMLForm.getHistory();
        if (listJSON != null) {
            for (int i = 0; i < listJSON.size(); i++) {
                Map<String, String> properties = listJSON.get(i);

                for (Map.Entry<String, String> values : properties.entrySet()) {
                    if (values.getKey().equalsIgnoreCase("consumer")) {
                        user.setClient(values.getValue());
                    }

                    if (values.getKey().equalsIgnoreCase("currency")) {
                        user.setCurrency(values.getValue());
                    }

                    if (values.getKey().equalsIgnoreCase("period")) {
                        user.setPeriod(Integer.parseInt(values.getValue()));
                    }
                }
            }
        }

        return user;
    }
}
