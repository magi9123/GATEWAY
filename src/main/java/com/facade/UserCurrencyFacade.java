package com.facade;

import com.models.UserFormModel;
import com.models.user.UserCurrencyAbstract;

public class UserCurrencyFacade {

    /**
     * Convert UserFormModel to java entity object
     * for t.user_history_currency or t.user_currency.
     *
     * @param UserFormModel user
     * @return UserCurrencyAbstract
     */
    public UserCurrencyAbstract convertToEntityObject(UserFormModel user) {

        UserCurrencyAbstract userData;

        Validator validator = new Validator();
        validator.start(user);

        MappingObject mappingObject = new MappingObject();
        userData = mappingObject.start(user);

        return userData;
    }


    /**
     * Convert xml file from given directory to java entity object
     * for t.user_history_currency or t.user_currency.
     *
     * @param String path
     * @return UserCurrencyAbstract
     */
    public UserCurrencyAbstract convertXMLFileToObject(String path) {
        UserFormModel user;

        ReadXmlSaxParse2 readXmlSaxParse2 = new ReadXmlSaxParse2();
        user = readXmlSaxParse2.start(path);

        UserCurrencyAbstract userData = convertToEntityObject(user);

        return userData;
    }

}
