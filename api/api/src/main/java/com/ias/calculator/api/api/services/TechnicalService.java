package com.ias.calculator.api.api.services;
import com.ias.calculator.api.api.entities.TechnicalEntity;

import java.util.List;
import java.util.Optional;

public interface TechnicalService {

    List<TechnicalEntity> findAll();
    Optional<TechnicalEntity> findById(Long id);
    TechnicalEntity save(TechnicalEntity technicalEntity);
    TechnicalEntity update(TechnicalEntity technicalEntity);
    void delete(Long id);
    TechnicalEntity findByCC(String cc);
}