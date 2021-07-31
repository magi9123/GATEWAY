package com.facade;

import com.models.Client;
import com.models.Currency;
import com.models.user.UserAbstract;
import com.models.user.UserCurrency;
import com.models.user.UserHistoryCurrency;
import com.repositories.ClientRepository;
import com.repositories.UserCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MappingObject {

    @Autowired
    private UserCurrencyRepository userCurrencyRepository;

    @Autowired
    private ClientRepository clientRepository;

    public UserAbstract start(final UserSax userSax) {

        UserAbstract user;
        if (userSax.getPeriod() == 0) {
            user = new UserCurrency();
        } else {
            user = new UserHistoryCurrency();
        }

        user.setRequestId(userSax.getRequestId());

        Client client = clientRepository.findByClientId(userSax.getClient());
        user.setClient(client);

        Currency currency = userCurrencyRepository.findByCurrency(userSax.getCurrency());
        user.setCurrency(currency);


        if (!(userSax.getTime() == null)) {
            user.setTime(userSax.getTime());
        }

        if (!(userSax.getPeriod() == 0)) {
            ((UserHistoryCurrency) user).setPeriod(userSax.getPeriod());
        }


        return user;
    }
}
