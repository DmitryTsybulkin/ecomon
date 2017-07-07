package com.itlab2017.services;


import com.itlab2017.domain.Sensor;

public interface SensorService {
    Iterable<Sensor> listAllSensors();

    Sensor getSensorById(Integer id);

    Sensor saveSensor(Sensor Device);
}
