package com.facade;

import com.models.UserFormModel;
import com.repositories.ClientRepository;
import com.repositories.UserCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Validator {

    @Autowired
    private UserCurrencyRepository userCurrencyRepository;

    @Autowired
    private ClientRepository clientRepository;

    public UserFormModel start(final UserFormModel userFormModel) {

        if (userFormModel.getRequestId() == null || userFormModel.getRequestId().isBlank()) {
            //TODO: throw custom exception
        } else {
            String requestId = userFormModel.getRequestId();
            boolean requestIdExist = userCurrencyRepository.existsById(requestId);

            if (requestIdExist) {
                //TODO: throw custom exception
            }
        }

        if (userFormModel.getClient() == null || userFormModel.getClient().isBlank()) {
            //TODO: throw custom exception
        } else {
            String clientId = userFormModel.getClient();
            boolean clientExist = clientRepository.existsById(clientId);

            if (clientExist) {
                //TODO: throw custom exception
            }
        }

        if (userFormModel.getCurrency() == null || userFormModel.getCurrency().isBlank()) {
            //TODO: throw custom exception
        }

        return userFormModel;
    }
}
