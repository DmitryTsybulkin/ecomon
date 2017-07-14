package com.itlab2017.controllers;

import com.itlab2017.domain.*;
import com.itlab2017.repositories.SensorRepository;
import com.itlab2017.repositories.StationRepository;
import com.itlab2017.services.LogService;
import com.itlab2017.services.SensorService;
import com.itlab2017.services.StationService;
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
    private StationRepository stationRepository;
    @Autowired
    private SensorService sensorService;
    @Autowired
    private LogService logService;
    @Autowired
    private StationService stationService;
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public List<Message> greeting(HelloMessage message) throws Exception {

        List<Message> messages = new ArrayList<Message>();

        for(Sensor sensor : sensorService.getSensorsByStationId(1)){
            List<Log> logs = logService.getLogsBySensorId(sensor.getId());
            if(logs.size()<1) continue;
            Collections.sort(logs,new Comparator<Log>() {
                @Override
                public int compare(Log o1, Log o2) {
                    return o1.getTimestamp().compareTo(o2.getTimestamp());
                }
            });
            Log log = logs.get(logs.size()-1);
            messages.add(new Message(log.getValue(), log.getTimestamp(), log.getSensor_id()));
        };
        return messages;
    }

}
