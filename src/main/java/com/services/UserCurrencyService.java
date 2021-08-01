package com.services;

import com.facade.UserFacade;
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

        UserFacade userFacade = new UserFacade();
        UserCurrencyAbstract userCurrencyAbstract = userFacade.save(userCurrencies);


//        String requestId = userCurrencies.getRequestId();
//        boolean requestIdExist = userCurrencyRepository.existsById(requestId);

//        if (!requestIdExist) {
        userCurrencyRepository.save(userCurrencyAbstract);
//            logger.info("Record is saved with id: " + requestId);
//        } else {
//            logger.info("Already exist record with id: " + requestId);
//        }
    }
}
