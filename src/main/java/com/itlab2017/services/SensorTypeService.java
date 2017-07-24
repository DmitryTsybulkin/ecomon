package com.itlab2017.services;


import com.itlab2017.domain.SensorType;

import java.util.List;

public interface SensorTypeService {
    Iterable<SensorType> listAllSensorTypes();

    SensorType getSensorTypeById(Integer id);

    SensorType saveSensorType(SensorType sensor);

}
