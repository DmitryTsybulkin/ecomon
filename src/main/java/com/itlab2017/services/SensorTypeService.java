package com.itlab2017.services;


import com.itlab2017.domain.SensorType;

public interface SensorTypeService {
    Iterable<SensorType> listAllSensorTypes();

    SensorType getSensorTypeById(Integer id);

    SensorType saveSensorType(SensorType sensor);

}
