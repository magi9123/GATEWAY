package com.services;

import com.models.user.UserAbstract;
import com.repositories.UserCurrencyRepository;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;


public class UserCurrencyService {

    Logger logger = LoggerFactory.getLogger(UserCurrencyService.class);


    @Autowired
    private UserCurrencyRepository userCurrencyRepository;

    public void save(UserAbstract userCurrencies) {

//        String requestId = userCurrencies.getRequestId();
//        boolean requestIdExist = userCurrencyRepository.existsById(requestId);

//        if (!requestIdExist) {
//            userCurrencyRepository.save(userCurrencies);
//            logger.info("Record is saved with id: " + requestId);
//        } else {
//            logger.info("Already exist record with id: " + requestId);
//        }
    }
}
