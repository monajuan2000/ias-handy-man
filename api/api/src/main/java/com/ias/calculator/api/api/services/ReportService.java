package com.ias.calculator.api.api.services;

import java.util.List;

import com.ias.calculator.api.api.entities.ReportEntity;

public interface ReportService {

    List<ReportEntity> findAll();
    ReportEntity findById(Long id);
    ReportEntity save(ReportEntity technicalEntity);
    ReportEntity update(ReportEntity technicalEntity);
    void delete(Long id);
    List<ReportEntity> findByTechnical(Long id);
}
