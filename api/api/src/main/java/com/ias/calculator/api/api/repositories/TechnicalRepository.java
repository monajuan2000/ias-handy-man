package com.ias.calculator.api.api.repositories;

import com.ias.calculator.api.api.entities.TechnicalEntity;
import com.ias.calculator.api.api.models.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaRepository<TechnicalEntity, Long> {

}
