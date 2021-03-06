package com.itlab2017.repositories;

import com.itlab2017.domain.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SensorRepository extends JpaRepository<Sensor, Integer>, JpaSpecificationExecutor<Sensor> {
}
