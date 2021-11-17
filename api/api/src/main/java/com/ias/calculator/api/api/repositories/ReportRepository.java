package com.ias.calculator.api.api.repositories;

import com.ias.calculator.api.api.entities.ReportEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long>{
    
}
