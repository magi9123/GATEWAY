package com.facade;

import com.models.Client;
import com.models.Currency;
import com.models.UserFormModel;
import com.models.user.UserCurrencyAbstract;
import com.models.user.UserCurrency;
import com.models.user.UserCurrencyHistory;
import com.repositories.ClientRepository;
import com.repositories.UserCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MappingObject {

    @Autowired
    private UserCurrencyRepository userCurrencyRepository;

    @Autowired
    private ClientRepository clientRepository;

    public UserCurrencyAbstract start(final UserFormModel userFormModel) {

        UserCurrencyAbstract user;
        if (userFormModel.getPeriod() == 0) {
            user = new UserCurrency();
        } else {
            user = new UserCurrencyHistory();
        }

        user.setRequestId(userFormModel.getRequestId());

        Client client = clientRepository.findByClientId(userFormModel.getClient());
        user.setClient(client);

        Currency currency = userCurrencyRepository.findByCurrency(userFormModel.getCurrency());
        user.setCurrency(currency);


        if (!(userFormModel.getTime() == null)) {
            user.setTime(userFormModel.getTime());
        }

        if (!(userFormModel.getPeriod() == 0)) {
            ((UserCurrencyHistory) user).setPeriod(userFormModel.getPeriod());
        }


        return user;
    }
}
