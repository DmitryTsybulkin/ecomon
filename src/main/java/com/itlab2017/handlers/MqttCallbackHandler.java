package com.itlab2017.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itlab2017.bootstrap.Initializer;
import com.itlab2017.domain.Log;
import com.itlab2017.domain.Sensor;
import com.itlab2017.domain.Station;
import com.itlab2017.factories.MqttClientFactory;
import com.itlab2017.mappedJSON.*;
import com.itlab2017.repositories.LogRepository;
import com.itlab2017.repositories.SensorRepository;
import com.itlab2017.repositories.StationRepository;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@Component
public class MqttCallbackHandler implements MqttCallback {

    private Logger log = Logger.getLogger(Initializer.class);
    @Autowired
    private MqttClientFactory mqttClientFactory;
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private SensorRepository sensorRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String topic, MqttMessage msg) throws MqttException, IOException {
        log.info(topic + ": " + msg.toString());
        if (topic.startsWith("api/")) {
            ApiResponse apiResponse = new ApiResponse(Status.ERROR);
            MqttMessage response = new MqttMessage();
            String responseTopic = "api/";
            if (topic.endsWith("getId")) {
                log.info("Регистрация станции");
                ApiGetId apiGetId = objectMapper.readValue(msg.getPayload(), ApiGetId.class);
                Station station = new Station();
                station.setName(apiGetId.getName());
                station.setApiKey(apiGetId.getApiKey());
                Set<Sensor> sensors = new HashSet<Sensor>();
                for (SensorKind sensorKind : apiGetId.getSensorKinds()) {
                    Sensor sensor = new Sensor();
                    sensor.setName(sensorKind.name());
                    sensor.setStation(station);
                    sensors.add(sensor);
                }
                station.setSensors(sensors);
                stationRepository.saveAndFlush(station);
                log.info("Сохранение успешно");
                List<Integer> sensorsIds = new ArrayList<>();
                for (Sensor sensor : station.getSensors()) {
                    sensorsIds.add(sensor.getId());
                }
                responseTopic += "getId/response/" + apiGetId.getRequestHash();
                apiResponse = new ApiGetIdResponse(Status.OK, station.getId(), sensorsIds.toArray(new Integer[sensorsIds.size()]));
                response.setPayload(objectMapper.writeValueAsBytes(apiResponse));
                mqttClientFactory.getSender().publish(responseTopic + "", response);
                log.info("Отправлено: " + response.toString());
            }
            if (topic.endsWith("update")) {
                log.info("Обновление данных сенсора");
                ApiUpdate apiUpdate = objectMapper.readValue(msg.getPayload(), ApiUpdate.class);
                Station station = stationRepository.findOne(apiUpdate.getId());
                if (apiUpdate.getApiKey().equals(station.getApiKey())) {
                    for (Map.Entry<Integer, String> entry : apiUpdate.getSensorsData().entrySet()) {
                        Log log = new Log();
                        log.setTimestamp(new Timestamp(System.currentTimeMillis()));
                        log.setValue(entry.getValue());
                        log.setSensor_id(entry.getKey());
                        logRepository.saveAndFlush(log);
//                        sensorRepository.saveAndFlush(sensor);
                    }
                    log.info("Обновление успешно");
                }
            }

        }

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }

}
