package com.itlab2017.bootstrap;

import com.itlab2017.domain.Station;
import com.itlab2017.domain.Log;
import com.itlab2017.domain.Sensor;
import com.itlab2017.repositories.DeviceRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DeviceLoader implements ApplicationListener<ContextRefreshedEvent> {

    private DeviceRepository deviceRepository;
    private Logger log = Logger.getLogger(DeviceLoader.class);

    @Autowired
    public void setDeviceRepository(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Station station = new Station();
        station.setName("Ардуино №1");

        Sensor sensor = new Sensor();
        sensor.setStation(station);
        sensor.setName("Датчик температуры");
        Set<Sensor> sensors = new HashSet<Sensor>();
        Set<Log> records = new HashSet<Log>();
        sensor.setRecords(records);
        sensors.add(sensor);
        station.setSensors(sensors);
        deviceRepository.save(station);

//        Session session = factory.openSession();
//        Query<Station> query = session.createQuery("select d from Station d where d.id >= 0");
//        new Thread(() -> {
//            Random random = new Random();
//            while (true) try {
//                Thread.sleep(1000);
//                Log log = new Log();
//                log.setValue( String.valueOf(random.nextDouble()*3+20));
//                log.setSensor(sensor);
//                log.setTimestamp(new Timestamp(System.currentTimeMillis()));
//                Date dt = new Date();
//                Calendar c = Calendar.getInstance();
//                c.setTime(dt);
//                c.add(Calendar.MINUTE, 1);
//                final Date dt2 = c.getTime();
////                recordRepository.save(record);
//                sensor.getRecords().removeIf(record1 -> record1.getTimestamp().before(dt2));
//                sensor.getRecords().add(log);
//                deviceRepository.save(station);
////                log.info("Добавлена запись. Всего: " + sensor.getRecords().size());
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }).start();
    }
}
