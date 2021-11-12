package com.ias.calculator.api.api.controllers;

import com.ias.calculator.api.api.entities.TechnicalEntity;
import com.ias.calculator.api.api.services.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TechnicalControllers {

    @Autowired
    private TechnicalService technicalService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/v1/technical/find-all")
    public List<TechnicalEntity> findAll(){
        return technicalService.findAll();
    }
}
