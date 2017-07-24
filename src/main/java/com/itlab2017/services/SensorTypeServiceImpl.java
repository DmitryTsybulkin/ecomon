package com.itlab2017.services;

import com.itlab2017.domain.Sensor;
import com.itlab2017.domain.SensorType;
import com.itlab2017.repositories.SensorRepository;
import com.itlab2017.repositories.SensorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorTypeServiceImpl implements SensorTypeService {
    @Autowired
    private SensorTypeRepository sensorTypeRepository;

    @Override
    public Iterable<SensorType> listAllSensorTypes() {
        return sensorTypeRepository.findAll();
    }

    @Override
    public SensorType getSensorTypeById(Integer id) {
        return sensorTypeRepository.findOne(id);
    }

    @Override
    public SensorType saveSensorType(SensorType sensorType) {
        return sensorTypeRepository.save(sensorType);
    }

}
