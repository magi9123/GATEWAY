package com.controller;

import com.models.FixerModel;
import com.services.FixerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FixerController {

    @Autowired
    private FixerService fixerService;

    @RequestMapping("/latest")
    @Scheduled(fixedRate = 360000 * 12)
    public void save(List<FixerModel> fixerModels) {
        fixerService.save(fixerModels);
    }
}
