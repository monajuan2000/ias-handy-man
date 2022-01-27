package com.ias.calculator.api.api.repositories;

import java.util.List;
import java.util.Optional;

import com.ias.calculator.api.api.entities.ReportEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long>{
    
    @Query(nativeQuery = true, value = "select * from reports where id_technical=?1")
    public List<ReportEntity> findByTechnical(Long id);
    
}
