package com.ias.calculator.api.api.repositories;

import java.util.Optional;

import com.ias.calculator.api.api.entities.TechnicalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaRepository<TechnicalEntity, Long> {

    @Query(nativeQuery = true, value = "select * from technicians where cc=?1")
    public Optional<TechnicalEntity> findByCC(String cc);

}
