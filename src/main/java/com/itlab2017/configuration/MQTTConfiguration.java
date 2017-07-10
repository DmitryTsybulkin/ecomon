//package com.itlab2017.configuration;
//
//import io.moquette.server.Server;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import java.io.File;
//import java.io.IOException;
//
//@Configuration
//public class MQTTConfiguration {
//
//    @Bean
//    public Server mqttServer(){
//        Server server = new Server();
//        try {
//            server.startServer(new File("src/main/resources/config/moquette.conf"));
//        } catch (IOException e) {
//            throw new ExceptionInInitializerError("Не удалось инициализировать MQTT сервер");
//        }
//        return server;
//    }
//}
//
