package com.facade;

import com.models.UserFormModel;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class ReadXmlSaxParse2 {

    public UserFormModel start(String path) {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try (InputStream is = getXMLFileAsStream()) {

            SAXParser saxParser = factory.newSAXParser();
            UserCurrencySax handler = new UserCurrencySax();
            saxParser.parse(is, handler);

            return handler.user;
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return new UserFormModel();
    }


    private static InputStream getXMLFileAsStream() {
        return ReadXmlSaxParse2.class.getClassLoader().getResourceAsStream("files/HistoryUser.xml");//HistoryUser //ConcreteUser
    }
}
