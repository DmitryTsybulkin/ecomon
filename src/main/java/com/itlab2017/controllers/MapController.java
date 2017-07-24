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

@Controller
public class MapController {

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String list(Model model){
        return "map";
    }

}
