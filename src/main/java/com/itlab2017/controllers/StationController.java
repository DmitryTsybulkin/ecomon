package com.itlab2017.controllers;

import com.itlab2017.bootstrap.Initializer;
import com.itlab2017.services.LogService;
import com.itlab2017.services.StationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@Controller
public class StationController {

    @Autowired
    private StationService stationService;
    @Autowired
    private LogService logService;

    private Logger log = Logger.getLogger(Initializer.class);


    @RequestMapping(value = "/stations", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("stations", stationService.listAllStations());
        return "stations";
    }

    @RequestMapping("station/{id}")
    public String showDevice(@PathVariable Integer id, Model model){
        model.addAttribute("station", stationService.getStationById(id));
        return "stationshow";
    }



}
