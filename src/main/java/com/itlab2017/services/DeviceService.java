package com.itlab2017.services;


import com.itlab2017.domain.Station;

public interface DeviceService {
    Iterable<Station> listAllDevices();

    Station getDeviceById(Integer id);

    Station saveDevice(Station Station);
}
