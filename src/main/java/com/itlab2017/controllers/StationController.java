package com.itlab2017.controllers;

import com.itlab2017.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StationController {

    private StationService stationService;

    @Autowired
    public void setStationService(StationService stationService) {
        this.stationService = stationService;
    }

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


//
//    @RequestMapping(value = "Station", method = RequestMethod.POST)
//    public String saveStation(Station device){
//
//        stationService.saveStation(device);
//
//        return "redirect:/Station/" + device.getId();
//    }

}
