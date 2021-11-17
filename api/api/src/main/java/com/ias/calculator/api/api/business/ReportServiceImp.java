package com.ias.calculator.api.api.business;

import java.util.List;

import com.ias.calculator.api.api.entities.ReportEntity;
import com.ias.calculator.api.api.entities.TechnicalEntity;
import com.ias.calculator.api.api.repositories.ReportRepository;
import com.ias.calculator.api.api.services.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImp implements ReportService{

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<ReportEntity> findAll() {
        return this.reportRepository.findAll();
    }

    @Override
    public ReportEntity findById(Long id) {
        return this.reportRepository.findById(id).orElseThrow();
    }

    @Override
    public ReportEntity save(ReportEntity technicalEntity) {
        return this.reportRepository.save(technicalEntity);
    }

    @Override
    public ReportEntity update(ReportEntity technicalEntity) {
        return this.reportRepository.saveAndFlush(technicalEntity);
    }

    @Override
    public void delete(Long id) {
        this.reportRepository.deleteById(id);
    }

    
    
}
