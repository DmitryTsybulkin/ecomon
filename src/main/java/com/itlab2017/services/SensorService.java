package com.itlab2017.services;


import com.itlab2017.domain.Sensor;

import java.util.List;

public interface SensorService {
    Iterable<Sensor> listAllSensors();

    Sensor getSensorById(Integer id);

    Sensor saveSensor(Sensor sensor);

    List<Sensor> getSensorsByStationId(Integer stationId);

}
