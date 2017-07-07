package com.itlab2017.repositories;

import com.itlab2017.domain.Record;
import com.itlab2017.domain.Sensor;
import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<Sensor, Integer> {
}
