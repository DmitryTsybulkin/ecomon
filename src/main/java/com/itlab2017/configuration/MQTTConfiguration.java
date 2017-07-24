package com.itlab2017.configuration;

import com.itlab2017.factories.MqttClientFactory;
import com.itlab2017.handlers.MqttCallbackHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQTTConfiguration {

    @Bean
    public MqttCallbackHandler mqttCallbackHandler() {
        return new MqttCallbackHandler();
    }

    @Bean
    public MqttClientFactory mqttFactory() {
        return new MqttClientFactory();
    }

}

