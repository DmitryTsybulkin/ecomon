package com.itlab2017.repositories;

import com.itlab2017.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
