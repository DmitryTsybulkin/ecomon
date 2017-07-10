package com.itlab2017.services;


import com.itlab2017.domain.Sensor;
import io.moquette.server.Server;

public interface MqttServerService {

    Server getMqttServer();
}
