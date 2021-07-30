package com.services;

import com.models.FixerModel;
import com.repositories.FixerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixerService {

    Logger logger = LoggerFactory.getLogger(FixerService.class);

    @Autowired
    private FixerRepository fixerRepository;

    public void save(List<FixerModel> currencies) {
        fixerRepository.saveAll(currencies);
        logger.info("Record for base currency " + currencies.get(0).getBaseCurrency() +
                " for date: " + currencies.get(0).getDate());
    }
}
