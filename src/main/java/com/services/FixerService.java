package com.services;

import com.models.FixerModel;
import com.repositories.FixerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixerService {

    @Autowired
    private FixerRepository fixerRepository;

    public void save(List<FixerModel> currencies) {
        fixerRepository.saveAll(currencies);
    }
}
