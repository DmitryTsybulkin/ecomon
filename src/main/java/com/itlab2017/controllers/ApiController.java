package com.itlab2017.controllers;

import com.itlab2017.bootstrap.Initializer;
import com.itlab2017.business.GraphMessageResponse;
import com.itlab2017.domain.Log;
import com.itlab2017.domain.Sensor;
import com.itlab2017.domain.Station;
import com.itlab2017.services.LogService;
import com.itlab2017.services.SensorService;
import com.itlab2017.services.StationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private LogService logService;
    @Autowired
    private StationService stationService;
    @Autowired
    private SensorService sensorService;
    private Logger log = Logger.getLogger(Initializer.class);

    // TODO: 03.08.2017 Дублирование кода. Вынести получение графика кода в отдельную логику
    @RequestMapping("/graphdata")
    @GetMapping
    public List<GraphMessageResponse> graphdata(Integer stationId) throws Exception {
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

    // TODO: 13.07.2017 убрать костыль для демодня
    @RequestMapping("/update")
    @GetMapping
    public String update(@RequestParam("light") String lightValue,
                         @RequestParam("noise") String noiseValue) {
        Log lightLog = new Log();
        lightLog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        lightLog.setValue(lightValue);
        lightLog.setSensor_id(1);
        Log noiseLog = new Log();
        noiseLog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        noiseLog.setValue(noiseValue);
        noiseLog.setSensor_id(2);
        log.info("Попытка обновления данных");
        logService.saveLog(lightLog);
        logService.saveLog(noiseLog);
        log.info("Обновление успешно");
        return "OK";
    }

    @RequestMapping("/stations")
    @GetMapping
    public Iterable<Station> stations() {

        return stationService.listAllStations();
    }

}