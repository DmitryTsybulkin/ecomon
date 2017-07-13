package com.itlab2017.controllers;

import com.itlab2017.domain.HelloMessage;
import com.itlab2017.domain.Message;
import com.itlab2017.domain.Log;
import com.itlab2017.domain.Sensor;
import com.itlab2017.services.LogService;
import com.itlab2017.services.SensorService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class WebApiController {

    @Autowired
    private SensorService sensorService;
    @Autowired
    private LogService logService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(HelloMessage message) throws Exception {


        List<Log> logs = logService.getLogsBySensorId(Integer.parseInt(message.getName()));
        if(logs.size()<1)return null;
        Collections.sort(logs,new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                return o1.getTimestamp().compareTo(o2.getTimestamp());
            }
        });
        Log record = logs.get(logs.size()-1);
        return new Message(record.getValue(), record.getTimestamp());
    }

}
