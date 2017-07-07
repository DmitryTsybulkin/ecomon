package com.itlab2017.bootstrap;

import com.itlab2017.domain.Device;
import com.itlab2017.domain.Record;
import com.itlab2017.domain.Sensor;
import com.itlab2017.repositories.DeviceRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class DeviceLoader implements ApplicationListener<ContextRefreshedEvent> {

    private DeviceRepository DeviceRepository;

    private Logger log = Logger.getLogger(DeviceLoader.class);

    @Autowired
    public void setDeviceRepository(DeviceRepository DeviceRepository) {
        this.DeviceRepository = DeviceRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Device device = new Device();
        device.setName("Ардуино №1");

        Sensor sensor = new Sensor();
        sensor.setDevice(device);
        sensor.setName("Датчик температуры");
        Set<Sensor> sensors = new HashSet<Sensor>();
        Set<Record> records = new HashSet<Record>();
        sensor.setRecords(records);
        sensors.add(sensor);
        device.setSensors(sensors);
        DeviceRepository.save(device);
        new Thread(() -> {
            Random random = new Random();
            while (true) try {
                Thread.sleep(1000);
                Record record = new Record();
                record.setValue( String.valueOf(random.nextDouble()*5+20));
                record.setSensor(sensor);
                record.setTimestamp(new Timestamp(System.currentTimeMillis()));
                sensor.getRecords().add(record);
                DeviceRepository.save(device);
                log.info("Добавлена запись");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
