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
            station.setLocation(new PGpoint(53.200663 + -0.00500 + (0.00500 - -0.00500) * rand.nextDouble(),
                    45.00464 + -0.00500 + (0.00500 - -0.00500) * rand.nextDouble()));
            station.setName("Arduino #" + i);

            stationService.saveStation(station);
            Set<Sensor> sensors = new HashSet<Sensor>();

            SensorType sensorTypeTemperature = new SensorType();
            sensorTypeTemperature.setSensorKind(SensorKind.TEMPERATURE);
            Sensor temperature = new Sensor();
            temperature.setName("Датчик температуры");
            temperature.setSensorType(sensorTypeTemperature);
            temperature.setStation(station);
            temperature.setStation_id(station.getId());
            sensors.add(temperature);

            SensorType sensorTypeHumidity = new SensorType();
            sensorTypeHumidity.setSensorKind(SensorKind.HUMIDITY);
            Sensor humidity = new Sensor();
            humidity.setName("Датчик влажности");
            humidity.setSensorType(sensorTypeHumidity);
            humidity.setStation(station);
            humidity.setStation_id(station.getId());
            sensors.add(humidity);

            SensorType sensorTypeDust = new SensorType();
            sensorTypeDust.setSensorKind(SensorKind.DUST);
            Sensor dust = new Sensor();
            dust.setName("Датчик пыли");
            dust.setSensorType(sensorTypeDust);
            dust.setStation(station);
            dust.setStation_id(station.getId());
            sensors.add(dust);

            SensorType sensorTypeMQ2 = new SensorType();
            sensorTypeMQ2.setSensorKind(SensorKind.MQ2);
            Sensor mq2 = new Sensor();
            mq2.setName("Датчик пропана и метана");
            mq2.setSensorType(sensorTypeMQ2);
            mq2.setStation(station);
            mq2.setStation_id(station.getId());
            sensors.add(mq2);

            station.setSensors(sensors);
            stationService.saveStation(station);
        }


        mqttClientFactory.getSubscriper();
    }
}
