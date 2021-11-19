package com.ias.calculator.api.api.services;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.ias.calculator.api.api.entities.ReportEntity;

public interface ReportService {

    List<ReportEntity> findAll();
    ReportEntity findById(Long id);
    ReportEntity save(ReportEntity technicalEntity);
    ReportEntity update(ReportEntity technicalEntity);
    void delete(Long id);
    List<ReportEntity> findByTechnical(Long id);
    Map<String, Long> numberOfHours(Long id, String wk) throws ParseException;
    String dia() throws ParseException;
}
