package com.facade;

import com.models.UserFormModel;
import com.models.user.UserCurrencyAbstract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class UserCurrencySax extends DefaultHandler {

    Logger logger = LoggerFactory.getLogger(UserCurrencySax.class);

    private StringBuilder values = new StringBuilder();
    List<UserCurrencyAbstract> users;
    final UserFormModel user = new UserFormModel();

    @Override
    public void startDocument() throws SAXException {
        users = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        values.setLength(0);

        String requestId = "";
        if (qName.equalsIgnoreCase("command")) {
            requestId = attributes.getValue("id");
            user.setRequestId(requestId);
        }

        if (qName.equalsIgnoreCase("get")) {

            String consumer = attributes.getValue("consumer");
            user.setClient(consumer);

        } else if (qName.equalsIgnoreCase("history")) {

            String consumer = attributes.getValue("consumer");
            user.setClient(consumer);

            String period = attributes.getValue("period");
            user.setPeriod(Integer.parseInt(period));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("currency")) {
            user.setCurrency(values.toString());
        }

        if (qName.equalsIgnoreCase("consumer")) {
            user.setCurrency(values.toString());
        }

        if (qName.equalsIgnoreCase("period")) {
            user.setCurrency(values.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        values.append(ch, start, length);
    }
}
