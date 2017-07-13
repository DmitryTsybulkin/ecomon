    package com.itlab2017.configuration;

import com.itlab2017.handlers.MqttCallbackHandler;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQTTConfiguration {

    int qos             = 2;
    String broker       = "tcp://m10.cloudmqtt.com:11067";
    String login = "fhbawzad";
    String password = "R8smNGTQ-o13";

    @Bean
    public MqttCallbackHandler mqttCallbackHandler(){
        return new MqttCallbackHandler();
    }


    @Bean("subscriper")
    public MqttClient mqttClientSubscriper() throws MqttException{
        MqttClient sampleClient = new MqttClient(broker, "aef7de28d52977f1b5cd0fecfdc151717610adf41e0aa33b4d9f7522a43337ef", new MemoryPersistence());
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setUserName(login);
        connOpts.setPassword(password.toCharArray());
        sampleClient.connect(connOpts);
        sampleClient.subscribe("#");
        return sampleClient;
    }

    @Bean("sender")
    public MqttClient mqttClientSender() throws MqttException{
        MqttClient sampleClient = new MqttClient(broker, "aef7de28d52977f1b5cd0fecfdc151717610adf41e0aa33b4d9f7522a43337ed", new MemoryPersistence());
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setUserName(login);
        connOpts.setPassword(password.toCharArray());
        sampleClient.connect(connOpts);
        return sampleClient;
    }

}

