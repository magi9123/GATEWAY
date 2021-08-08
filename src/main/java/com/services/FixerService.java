package com.services;

import com.google.gson.GsonBuilder;
import com.models.Currency;
import com.models.FixerJSONFormat;
import com.models.FixerModel;
import com.repositories.FixerRepository;
import com.repositories.UserCurrencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.util.*;

@Service
public class FixerService {

    Logger logger = LoggerFactory.getLogger(FixerService.class);

    @Autowired
    private FixerRepository fixerRepository;

    @Autowired
    private UserCurrencyRepository currencyRepository;

    public void save() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://data.fixer.io/api/latest?access_key=a59542744c84078d88423d1d30b6ba47"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        FixerJSONFormat currencies = new GsonBuilder().create().fromJson(response.body(), FixerJSONFormat.class);

        Set<FixerModel> fixerModel = createEntities(currencies);


        fixerRepository.saveAll(fixerModel);
        logger.info("Record for base currency " + currencies.getBase() +
                " for date: " + currencies.getDate());

    }

    private Set<FixerModel> createEntities(FixerJSONFormat currencies) {
        Currency currencyBase = currencyRepository.findByCurrency(currencies.getBase());

        Set<FixerModel> fixerModelList = new HashSet<>();
        for (Map.Entry<String, Double> map : currencies.getRates().entrySet()) {
            FixerModel fixerModel1 = new FixerModel();

            fixerModel1.setDate(Date.valueOf(currencies.getDate()));
            fixerModel1.setBaseCurrency(currencyBase);

            Currency currencyTarget = currencyRepository.findByCurrency(map.getKey());
            fixerModel1.setTargetCurrency(currencyTarget);
            fixerModel1.setAmount(map.getValue());

            fixerModelList.add(fixerModel1);
        }

        return fixerModelList;
    }
}
