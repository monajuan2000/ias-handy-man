package com.ias.calculator.api.api.business;

import com.ias.calculator.api.api.entities.TechnicalEntity;
import com.ias.calculator.api.api.repositories.TechnicalRepository;
import com.ias.calculator.api.api.services.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalImp implements TechnicalService {

    @Autowired
    private TechnicalRepository technicalRepository;

    @Override
    public List<TechnicalEntity> findAll() {
        return this.technicalRepository.findAll();
    }

    @Override
    public TechnicalEntity findById(Long id) {
        return this.technicalRepository.findById(id).orElseThrow();
    }

    @Override
    public TechnicalEntity save(TechnicalEntity technicalEntity) {
        return this.technicalRepository.save(technicalEntity);
    }

    @Override
    public TechnicalEntity update(TechnicalEntity technicalEntity) {
        return this.technicalRepository.save(technicalEntity);
    }

    @Override
    public void delete(Long id) {
        this.technicalRepository.deleteById(id);
    }
}
