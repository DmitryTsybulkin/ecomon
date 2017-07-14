package com.itlab2017.controllers;

import com.itlab2017.bootstrap.Initializer;
import com.itlab2017.domain.Log;
import com.itlab2017.services.LogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private LogService logService;

    private Logger log = Logger.getLogger(Initializer.class);

    @RequestMapping("/devices")
    @PostMapping
    public int devices(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return 2;
    }
    // TODO: 13.07.2017 убрать костыль для демодня
    @RequestMapping("/update")
    @GetMapping
    public String update(@RequestParam("light") String lightValue,
                               @RequestParam("noise") String noiseValue){
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
}