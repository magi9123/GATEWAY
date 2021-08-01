package com.services;

import com.facade.UserCurrencyFacade;
import com.models.UserFormModel;
import com.models.user.UserCurrencyAbstract;
import com.repositories.UserCurrencyRepository;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;


public class UserCurrencyService {

    Logger logger = LoggerFactory.getLogger(UserCurrencyService.class);


    @Autowired
    private UserCurrencyRepository userCurrencyRepository;

    public void save(UserFormModel userCurrencies) {

        UserCurrencyFacade userCurrencyFacade = new UserCurrencyFacade();
        UserCurrencyAbstract userCurrencyAbstract = userCurrencyFacade.convertToEntityObject(userCurrencies);

        userCurrencyRepository.save(userCurrencyAbstract);
    }
}
