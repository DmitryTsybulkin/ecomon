package com.itlab2017.factories;

import com.itlab2017.bootstrap.Initializer;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MqttClientFactory {

    private final String broker = "tcp://m10.cloudmqtt.com:11067";
    private final String login = "fhbawzad";
    private final String password = "R8smNGTQ-o13";
    private Logger log = Logger.getLogger(Initializer.class);
    @Autowired
    private MqttCallback mqttCallback;
    private MqttClient subscriper;
    private MqttClient sender;
    private MqttConnectOptions connectOptions = new MqttConnectOptions();

    public MqttClientFactory() {
        connectOptions.setCleanSession(true);
        connectOptions.setUserName(login);
        connectOptions.setPassword(password.toCharArray());
    }

    private MqttClient buildMqttClient() throws MqttException {
        MqttClient sampleClient = new MqttClient(broker, UUID.randomUUID().toString(), new MemoryPersistence());
        sampleClient.connect(connectOptions);
        sampleClient.subscribe("#");
        return sampleClient;
    }

    public MqttClient getSender() {
        try {
            if (sender == null) {
                sender = buildMqttClient();
                return sender;
            }
            if (!sender.isConnected()) sender.connect();
            return sender;
        } catch (MqttException e) {
            log.error(e.getMessage());
            throw new RuntimeException("Cant build MqttClint");
        }
    }

    public MqttClient getSubscriper() {
        try {
            if (subscriper == null) {
                subscriper = buildMqttClient();
                subscriper.setCallback(mqttCallback);
                return subscriper;
            }
            if (!subscriper.isConnected()) subscriper.connect();
            return subscriper;
        } catch (MqttException e) {
            log.error(e.getMessage());
            throw new RuntimeException("Cant build MqttClint");
        }
    }
}
