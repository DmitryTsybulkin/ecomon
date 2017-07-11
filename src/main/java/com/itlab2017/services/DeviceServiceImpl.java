package com.itlab2017.services;

import com.itlab2017.domain.Station;
import com.itlab2017.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {
    private DeviceRepository DeviceRepository;

    @Autowired
    public void setDeviceRepository(DeviceRepository DeviceRepository) {
        this.DeviceRepository = DeviceRepository;
    }

    @Override
    public Iterable<Station> listAllDevices() {
        return DeviceRepository.findAll();
    }

    @Override
    public Station getDeviceById(Integer id) {
        return DeviceRepository.findOne(id);
    }

    @Override
    public Station saveDevice(Station Station) {
        return DeviceRepository.save(Station);
    }
}
