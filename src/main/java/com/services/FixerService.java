package com.services;

import com.google.gson.GsonBuilder;
import com.models.FixerJSONFormat;
import com.models.FixerModel;
import com.repositories.FixerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class FixerService {

    Logger logger = LoggerFactory.getLogger(FixerService.class);

    @Autowired
    private FixerRepository fixerRepository;


    public void save() throws IOException, InterruptedException {

        List<FixerJSONFormat> currencies = new LinkedList<>();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://data.fixer.io/api/latest?access_key=a59542744c84078d88423d1d30b6ba47"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        currencies = Arrays.asList(new GsonBuilder().create().fromJson(response.body(), FixerJSONFormat.class));

        FixerModel fixerModel = new FixerModel();

        // ....


        fixerRepository.save(fixerModel);
        logger.info("Record for base currency " + fixerModel.getBaseCurrency() +
                " for date: " + fixerModel.getDate());

    }
}
