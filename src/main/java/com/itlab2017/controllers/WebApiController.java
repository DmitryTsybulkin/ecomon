package com.itlab2017.controllers;

import com.itlab2017.domain.HelloMessage;
import com.itlab2017.domain.Message;
import com.itlab2017.domain.Log;
import com.itlab2017.domain.Sensor;
import com.itlab2017.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Controller
public class WebApiController {

    private SensorService sensorService;

    @Autowired
    public void setDeviceService(SensorService sensorService) {
        this.sensorService = sensorService;
    }
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(HelloMessage message) throws Exception {
        System.out.print("test");
        Sensor sensor = sensorService.getSensorById(Integer.parseInt(message.getName()));
        ArrayList<Log> records = new ArrayList<Log>(sensor.getRecords());
        Collections.sort(records,new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                return o1.getTimestamp().compareTo(o2.getTimestamp());
            }
        });
        Log record = records.get(records.size()-1);
        return new Message(record.getValue(), record.getTimestamp());
    }
    @MessageMapping("/station")
    @SendTo("/topic/station")
    public String station() throws Exception {
        return "test123";
    }




}
