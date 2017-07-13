package com.itlab2017.repositories;

import com.itlab2017.domain.Sensor;
import com.itlab2017.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}
