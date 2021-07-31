package com.facade;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class ReadXmlSaxParse2 {

    public static UserSax start() {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try (InputStream is = getXMLFileAsStream()) {

            SAXParser saxParser = factory.newSAXParser();
            UserCurrencySax handler = new UserCurrencySax();
            saxParser.parse(is, handler);

            return handler.user;
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return new UserSax();
    }


    private static InputStream getXMLFileAsStream() {
        return ReadXmlSaxParse2.class.getClassLoader().getResourceAsStream("files/HistoryUser.xml");//HistoryUser //ConcreteUser
    }
}
