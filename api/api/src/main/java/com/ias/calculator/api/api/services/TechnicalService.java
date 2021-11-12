package com.ias.calculator.api.api.services;

import com.ias.calculator.api.api.entities.TechnicalEntity;

import java.util.List;

public interface TechnicalService {

    List<TechnicalEntity> findAll();
    TechnicalEntity findById(Long id);
    TechnicalEntity save(TechnicalEntity technicalEntity);
    TechnicalEntity update(TechnicalEntity technicalEntity);
}
