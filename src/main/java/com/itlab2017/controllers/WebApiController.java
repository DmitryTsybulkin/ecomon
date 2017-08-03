package com.itlab2017.controllers;

import com.itlab2017.business.GraphMessageResponse;
import com.itlab2017.domain.Log;
import com.itlab2017.domain.Sensor;
import com.itlab2017.repositories.StationRepository;
import com.itlab2017.services.LogService;
import com.itlab2017.services.SensorService;
import com.itlab2017.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    private List<GraphMessageResponse> GetGraphDatas(Integer stationId) {
        List<GraphMessageResponse> graphMessageResponses = new ArrayList<GraphMessageResponse>();
        for (Sensor sensor : sensorService.getSensorsByStationId(stationId)) {
            List<Log> logs = logService.getLogsBySensorId(sensor.getId());
            if (logs.size() < 1) continue;
            Collections.sort(logs, new Comparator<Log>() {
                @Override
                public int compare(Log o1, Log o2) {
                    return o1.getTimestamp().compareTo(o2.getTimestamp());
                }
            });
            Log log = logs.get(logs.size() - 1);
            graphMessageResponses.add(new GraphMessageResponse(log.getValue(), log.getTimestamp(), log.getSensor_id()));
        }
        return graphMessageResponses;
    }

    @RequestMapping("/graphdata")
    @GetMapping
    public List<GraphMessageResponse> graphdataGet(Integer stationId) throws Exception {
        return GetGraphDatas(stationId);
    }

    @MessageMapping("/graphdata")
    @SendTo("/topic/greetings")
    public List<GraphMessageResponse> graphdata(Integer stationId) throws Exception {
        return GetGraphDatas(stationId);
    }

}
