package com.itlab2017.bootstrap;

import com.itlab2017.configuration.MQTTConfiguration;
import com.itlab2017.domain.Sensor;
import com.itlab2017.domain.SensorType;
import com.itlab2017.domain.Station;
import com.itlab2017.factories.MqttClientFactory;
import com.itlab2017.handlers.MqttCallbackHandler;
import com.itlab2017.mappedJSON.SensorKind;
import com.itlab2017.repositories.StationRepository;
import com.itlab2017.services.StationService;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private StationService stationService;
    private Logger log = Logger.getLogger(Initializer.class);
    @Autowired
    private MqttClientFactory mqttClientFactory;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)  {
// TODO: 13.07.2017 убрать костыль для демодня
        Station station = new Station();
        station.setName("Arduino #1");
        stationService.saveStation(station);
        Set<Sensor> sensors = new HashSet<Sensor>();
        SensorType sensorTypeLight = new SensorType();
        sensorTypeLight.setName("BH1750");
        sensorTypeLight.setSensorKind(SensorKind.LIGHT);
        Sensor light = new Sensor();
        light.setSensorType(sensorTypeLight);
        light.setStation(station);
        light.setStation_id(station.getId());
        sensors.add(light);

        SensorType sensorTypeNoise = new SensorType();
        sensorTypeNoise.setName("RKP-SS-LM393");
        sensorTypeNoise.setSensorKind(SensorKind.NOISE);
        Sensor noise = new Sensor();
        noise.setSensorType(sensorTypeNoise);
        noise.setStation(station);
        noise.setStation_id(station.getId());
        sensors.add(noise);

        station.setSensors(sensors);
        stationService.saveStation(station);

        mqttClientFactory.getSubscriper();


//        Station station = new Station();
//        station.setName("Ардуино №1");
//
//        Sensor sensor = new Sensor();
//        sensor.setStation(station);
//        sensor.setName("Датчик температуры");
//        Set<Sensor> sensors = new HashSet<Sensor>();
//        Set<Log> records = new HashSet<Log>();
//        sensor.setLogs(records);
//        sensors.add(sensor);
//        station.setSensors(sensors);
//        deviceRepository.save(station);

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
//                sensor.getLogs().removeIf(record1 -> record1.getTimestamp().before(dt2));
//                sensor.getLogs().add(log);
//                deviceRepository.save(station);
////                log.info("Добавлена запись. Всего: " + sensor.getLogs().size());
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }).start();
    }
}
