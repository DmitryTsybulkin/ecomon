package com.itlab2017.bootstrap;

import com.itlab2017.domain.Device;
import com.itlab2017.domain.Record;
import com.itlab2017.domain.Sensor;
import com.itlab2017.repositories.DeviceRepository;
import com.itlab2017.repositories.RecordRepository;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sun.util.calendar.BaseCalendar;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.Date;

@Component
public class DeviceLoader implements ApplicationListener<ContextRefreshedEvent> {

    private DeviceRepository DeviceRepository;
    private RecordRepository recordRepository;

    private Logger log = Logger.getLogger(DeviceLoader.class);

    @Autowired
    public void setDeviceRepository(DeviceRepository DeviceRepository) {
        this.DeviceRepository = DeviceRepository;
    }
    @Autowired
    public void setRecordRepository(DeviceRepository recordRepository) {
        this.DeviceRepository = recordRepository;
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

//        Session session = factory.openSession();
//        Query<Device> query = session.createQuery("select d from Device d where d.id >= 0");


        new Thread(() -> {
            Random random = new Random();
            while (true) try {
                Thread.sleep(1000);
                Record record = new Record();
                record.setValue( String.valueOf(random.nextDouble()*3+20));
                record.setSensor(sensor);
                record.setTimestamp(new Timestamp(System.currentTimeMillis()));
                Date dt = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                c.add(Calendar.MINUTE, 1);
                final Date dt2 = c.getTime();
//                recordRepository.save(record);
                sensor.getRecords().removeIf(record1 -> record1.getTimestamp().before(dt2));
                sensor.getRecords().add(record);
                DeviceRepository.save(device);
//                log.info("Добавлена запись. Всего: " + sensor.getRecords().size());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
