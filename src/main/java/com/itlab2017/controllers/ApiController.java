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
    public String update(@RequestParam("temperature") String temperatureValue,
                         @RequestParam("humidity") String humidityValue,
                         @RequestParam("dust") String dustValue,
                         @RequestParam("mq2") String mq2Value,
                         @RequestParam("mq9") String mq9Value,
                         @RequestParam("mq131") String mq131Value) {
        Log temperatureLog = new Log();
        temperatureLog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        temperatureLog.setValue(temperatureValue);
        temperatureLog.setSensor_id(1);

        Log humidityLog = new Log();
        humidityLog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        humidityLog.setValue(humidityValue);
        humidityLog.setSensor_id(2);

        Log dustLog = new Log();
        dustLog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        dustLog.setValue(dustValue);
        dustLog.setSensor_id(3);

        Log mq2Log = new Log();
        mq2Log.setTimestamp(new Timestamp(System.currentTimeMillis()));
        mq2Log.setValue(mq2Value);
        mq2Log.setSensor_id(4);

        Log mq9Log = new Log();
        mq9Log.setTimestamp(new Timestamp(System.currentTimeMillis()));
        mq9Log.setValue(mq9Value);
        mq9Log.setSensor_id(5);

        Log mq131Log = new Log();
        mq131Log.setTimestamp(new Timestamp(System.currentTimeMillis()));
        mq131Log.setValue(mq9Value);
        mq131Log.setSensor_id(6);

        log.info("Попытка обновления данных");
        logService.saveLog(temperatureLog);
        logService.saveLog(humidityLog);
        logService.saveLog(dustLog);
        logService.saveLog(mq2Log);
        logService.saveLog(mq9Log);
        logService.saveLog(mq131Log);
        log.info("Обновление успешно");
        return "OK";
    }

    @RequestMapping("/stations")
    @GetMapping
    public Iterable<Station> stations() {

        return stationService.listAllStations();
    }

}