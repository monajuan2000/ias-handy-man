package com.ias.calculator.api.api.controllers;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.ias.calculator.api.api.entities.ReportEntity;
import com.ias.calculator.api.api.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/v1/reports/find-all")
    public List<ReportEntity> findAll(){
        return reportService.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/v1/reports/hours/{id}/{wk}")
    public Map<String, Float> numberOfHours(@PathVariable("id") Long id, @PathVariable("wk") String wk) throws ParseException{
        return reportService.numberOfHours(id,wk);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/api/v1/reports/update")
    public ReportEntity update(@RequestBody ReportEntity technical){
        return reportService.update(technical);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/v1/reports/save")
    public ReportEntity save(@RequestBody ReportEntity technical){
        return reportService.save(technical);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/api/v1/reports/delete/{id}")
    public void delete(@PathVariable Long id){
        reportService.delete(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/v1/reports/findByTechnical/{id}")
    public List<ReportEntity> findByTechnical(@PathVariable Long id){
        return reportService.findByTechnical(id);
    }
    
}
