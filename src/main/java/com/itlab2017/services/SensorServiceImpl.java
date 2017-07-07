package com.itlab2017.services;

import com.itlab2017.domain.Sensor;
import com.itlab2017.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorServiceImpl implements SensorService {
    private SensorRepository SensorRepository;

    @Autowired
    public void setSensorRepository(SensorRepository SensorRepository) {
        this.SensorRepository = SensorRepository;
    }

    @Override
    public Iterable<Sensor> listAllSensors() {
        return SensorRepository.findAll();
    }

    @Override
    public Sensor getSensorById(Integer id) {
        return SensorRepository.findOne(id);
    }

    @Override
    public Sensor saveSensor(Sensor Sensor) {
        return SensorRepository.save(Sensor);
    }
}
