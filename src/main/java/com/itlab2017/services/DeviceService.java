package com.itlab2017.services;


import com.itlab2017.domain.Device;

public interface DeviceService {
    Iterable<Device> listAllDevices();

    Device getDeviceById(Integer id);

    Device saveDevice(Device Device);
}
