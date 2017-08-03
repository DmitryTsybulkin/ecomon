package com.itlab2017.bootstrap;

import com.itlab2017.domain.Sensor;
import com.itlab2017.domain.SensorType;
import com.itlab2017.domain.Station;
import com.itlab2017.factories.MqttClientFactory;
import com.itlab2017.mappedjson.SensorKind;
import com.itlab2017.services.StationService;
import org.apache.log4j.Logger;
import org.postgresql.geometric.PGpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private StationService stationService;
    private Logger log = Logger.getLogger(Initializer.class);
    @Autowired
    private MqttClientFactory mqttClientFactory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            Station station = new Station();
            station.setLocation(new PGpoint(53.200663 + -0.000500 + (0.000500 - -0.000500) * rand.nextDouble(),
                    45.00464 + -0.000500 + (0.000500 - -0.000500) * rand.nextDouble()));
            station.setName("Arduino #" + i);

            stationService.saveStation(station);
            Set<Sensor> sensors = new HashSet<Sensor>();
            SensorType sensorTypeLight = new SensorType();

            sensorTypeLight.setSensorKind(SensorKind.LIGHT);
            Sensor light = new Sensor();
            light.setName("BH1750");
            light.setSensorType(sensorTypeLight);
            light.setStation(station);
            light.setStation_id(station.getId());
            sensors.add(light);
            SensorType sensorTypeNoise = new SensorType();
            sensorTypeNoise.setSensorKind(SensorKind.NOISE);
            Sensor noise = new Sensor();
            noise.setName("RKP-SS-LM393");
            noise.setSensorType(sensorTypeNoise);
            noise.setStation(station);
            noise.setStation_id(station.getId());
            sensors.add(noise);
            station.setSensors(sensors);
            stationService.saveStation(station);
        }


        mqttClientFactory.getSubscriper();
    }
}
