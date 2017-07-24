package com.itlab2017.repositories;

import com.itlab2017.domain.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SensorTypeRepository extends JpaRepository<SensorType, Integer>, JpaSpecificationExecutor<SensorType> {
}
