package com.facade;

import com.models.UserFormModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class ReadXmlSaxParse2 {

    Logger logger = LoggerFactory.getLogger(ReadXmlSaxParse2.class);

    public UserFormModel convertXmlFileToObject(String path) {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try (InputStream is = getXMLFileAsStream(path)) {

            SAXParser saxParser = factory.newSAXParser();
            UserCurrencySax handler = new UserCurrencySax();
            saxParser.parse(is, handler);

            return handler.user;
        } catch (IOException | SAXException | ParserConfigurationException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        return new UserFormModel();
    }


    private static InputStream getXMLFileAsStream(String path) {
        return ReadXmlSaxParse2.class.getClassLoader().getResourceAsStream(path);
    }
}
