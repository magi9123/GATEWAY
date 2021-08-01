package com.facade;

import com.exception.RecordNotFoundException;
import com.models.UserFormModel;
import com.repositories.ClientRepository;
import com.repositories.UserCurrencyRepository;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.MissingFormatArgumentException;

public class Validator {

    Logger logger = LoggerFactory.getLogger(Validator.class);

    @Autowired
    private UserCurrencyRepository userCurrencyRepository;

    @Autowired
    private ClientRepository clientRepository;

    public UserFormModel validate(final UserFormModel userFormModel) {

        if (userFormModel.getRequestId() == null || userFormModel.getRequestId().isBlank()) {
            throw new MissingFormatArgumentException("requestId missing in request");
        } else {
            String requestId = userFormModel.getRequestId();
            boolean requestIdExist = userCurrencyRepository.existsById(requestId);

            if (requestIdExist) {
                throw new RecordNotFoundException("Already exist request with id: " + requestId);
            }
        }

        if (userFormModel.getClient() == null || userFormModel.getClient().isBlank()) {
            throw new MissingFormatArgumentException("Client id missing in request");
        } else {
            String clientId = userFormModel.getClient();
            boolean clientExist = clientRepository.existsById(clientId);

            if (clientExist) {
                throw new RecordNotFoundException("Does not exist client in our database with id: " + clientId);
            }
        }

        if (userFormModel.getCurrency() == null || userFormModel.getCurrency().isBlank()) {
            throw new MissingFormatArgumentException("currency missing in request");
        }

        return userFormModel;
    }
}
