package com.itlab2017.services;

import com.itlab2017.domain.Sensor;
import com.itlab2017.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public Iterable<Sensor> listAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor getSensorById(Integer id) {
        return sensorRepository.findOne(id);
    }

    @Override
    public Sensor saveSensor(Sensor Sensor) {
        return sensorRepository.save(Sensor);
    }

    @Override
    public List<Sensor> getSensorsByStationId(Integer stationId) {
        return sensorRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("station_id"), stationId);
        });
    }

}
