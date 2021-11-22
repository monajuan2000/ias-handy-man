package com.ias.calculator.api.api.controllers;
import com.ias.calculator.api.api.entities.TechnicalEntity;
import com.ias.calculator.api.api.services.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class TechnicalControllers {

    @Autowired
    private TechnicalService technicalService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/v1/technical/find-all")
    public List<TechnicalEntity> findAll(){
        return technicalService.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/api/v1/technical/update")
    public TechnicalEntity update(@RequestBody TechnicalEntity technical){
        return technicalService.update(technical);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/v1/technical/save")
    public TechnicalEntity save(@RequestBody TechnicalEntity technical){
        return technicalService.save(technical);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/api/v1/technical/delete/{id}")
    public void delete(@PathVariable Long id){
         technicalService.delete(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/v1/technical/findByCC/{cc}")
    public TechnicalEntity findByCC(@PathVariable String cc){
        return technicalService.findByCC(cc);
    }
}
