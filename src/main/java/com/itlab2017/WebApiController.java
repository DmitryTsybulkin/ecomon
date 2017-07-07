package com.itlab2017;

import com.itlab2017.domain.Record;
import com.itlab2017.domain.Sensor;
import com.itlab2017.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(HelloMessage message) throws Exception {
        Sensor sensor = sensorService.getSensorById(Integer.parseInt(message.getName()));
        ArrayList<Record > records = new ArrayList<Record>(sensor.getRecords());
        Collections.sort(records,new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.getTimestamp().compareTo(o2.getTimestamp());
            }
        });
        Record record = records.get(records.size()-1);
        return new Message(record.getValue(), record.getTimestamp());
    }

}
