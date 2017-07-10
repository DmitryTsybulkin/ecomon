package com.itlab2017.controllers;
import java.util.ArrayList;
import java.util.List;

import com.itlab2017.domain.Device;
import com.itlab2017.services.MqttServerService;
import io.moquette.spi.impl.subscriptions.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private MqttServerService mqttServerService;

    @Autowired
    public void setMqttServerService(MqttServerService mqttServerService) {
        this.mqttServerService = mqttServerService;
    }

    @RequestMapping("/devices")
    @PostMapping
    public int devices(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        List<Subscription> subscriptions = mqttServerService.getMqttServer().getSubscriptions();
        return subscriptions.size();
    }

}