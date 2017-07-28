package com.itlab2017.services;

import com.itlab2017.domain.Log;
import com.itlab2017.domain.Sensor;
import com.itlab2017.domain.SensorType;
import com.itlab2017.domain.Station;
import com.itlab2017.mappedJSON.SensorKind;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest

@Transactional
@ActiveProfiles("development, production")
@RunWith(SpringJUnit4ClassRunner.class)
public class DataServicesTests {
    @Autowired
    private StationService stationService;
    @Autowired
    private SensorService sensorService;
    @Autowired
    private SensorTypeService sensorTypeService;
    @Autowired
    private LogService logService;
    @Test
    public void createNewStation() throws Exception {
        Station station = new Station();
        station.setName("test");
        station.setApiKey("test");

        stationService.saveStation(station);
        assert(station.getId()).longValue()!=0;
    }
    @Test
    public void createSensor() throws Exception {
        Sensor sensor = new Sensor();
        sensor.setName("test");
        sensorService.saveSensor(sensor);
        assert(sensor.getId()).longValue()!=0;
    }
    @Test
    public void createSensorType() throws Exception{

        SensorType sensorType = new SensorType();
        sensorType.setName("test");
        sensorType.setSensorKind(SensorKind.TEMPERATURE);
        sensorTypeService.saveSensorType(sensorType);
        assert(sensorType.getId()).longValue()!=0;
    }
    @Test
    public void createLog() throws Exception{

        Log log = new Log();
        logService.saveLog(log);
        log.setValue("test");
        log.setTimestamp(Timestamp.from(Instant.now()));
        assert(log.getId()).longValue()!=0;
    }
    @Test
    public void testHierarchyMapping() throws Exception{

        Station station = new Station();
        Set<Sensor> sensors = new HashSet<Sensor>();
        SensorType sensorType = new SensorType();
        for (int i = 0; i < 10; i++) {
            Sensor sensor = new Sensor();
            sensor.setStation(station);
            sensor.setSensorType(sensorType);
            Set<Log> logs = new HashSet<Log>();
            for (int j = 0; j < 10; j++) {
                Log log = new Log();
                log.setSensor(sensor);
            }
            sensor.setLogs(logs);
            sensors.add(sensor);
        }
        station.setSensors(sensors);
    }

}