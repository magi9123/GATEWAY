package com.services;

import com.models.user.UserAbstract;
import com.repositories.UserCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class UserCurrencyService {

    @Autowired
    private UserCurrencyRepository userCurrencyRepository;

    public void save(UserAbstract userCurrencies) {

        String requestId = userCurrencies.getRequestId();
        boolean requestIdExist = userCurrencyRepository.existsById(requestId);

        if (!requestIdExist) {
            userCurrencyRepository.save(userCurrencies);
            //logger
        } else {
                 //logger
        }
    }
}
