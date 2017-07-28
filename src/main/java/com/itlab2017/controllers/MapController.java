package com.itlab2017.controllers;

import com.itlab2017.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MapController {

    @Autowired
    private StationService stationService;


    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("stations", stationService.listAllStations());
        return "map";
    }
}
