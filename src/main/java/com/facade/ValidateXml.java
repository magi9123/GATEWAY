package com.facade;

import com.repositories.ClientRepository;
import com.repositories.UserCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidateXml {

    @Autowired
    private UserCurrencyRepository userCurrencyRepository;

    @Autowired
    private ClientRepository clientRepository;

    public UserSax start(final UserSax userSax) {

        if (userSax.getRequestId() == null || userSax.getRequestId().isBlank()) {
            //TODO: throw custom exception
        } else {
            String requestId = userSax.getRequestId();
            boolean requestIdExist = userCurrencyRepository.existsById(requestId);

            if (requestIdExist) {
                //TODO: throw custom exception
            }
        }

        if (userSax.getClient() == null || userSax.getClient().isBlank()) {
            //TODO: throw custom exception
        } else {
            String clientId = userSax.getClient();
            boolean clientExist = clientRepository.existsById(clientId);

            if (clientExist) {
                //TODO: throw custom exception
            }
        }

        if (userSax.getCurrency() == null || userSax.getCurrency().isBlank()) {
            //TODO: throw custom exception
        }

        return userSax;
    }
}
