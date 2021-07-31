package com;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class ReadXmlSaxParse2 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try (InputStream is = getXMLFileAsStream()) {

            SAXParser saxParser = factory.newSAXParser();
            UserCurrencySax handler = new UserCurrencySax();
            saxParser.parse(is, handler);

        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }


    private static InputStream getXMLFileAsStream() {
        return ReadXmlSaxParse2.class.getClassLoader().getResourceAsStream("files/HistoryUser.xml");//HistoryUser //ConcreteUser
    }
}
