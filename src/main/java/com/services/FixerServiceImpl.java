package com.services;

import com.models.FixerModel;
import com.repositories.FixerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixerServiceImpl{

    @Autowired
    private FixerRepository fixerRepository;

    public Iterable<FixerModel> save(List<FixerModel> currencies){
        return fixerRepository.save(currencies);
    }
}
