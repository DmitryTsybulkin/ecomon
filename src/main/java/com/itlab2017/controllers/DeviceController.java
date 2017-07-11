package com.itlab2017.controllers;

import com.itlab2017.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeviceController {

    private DeviceService DeviceService;

    @Autowired
    public void setDeviceService(DeviceService DeviceService) {
        this.DeviceService = DeviceService;
    }

    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("devices", DeviceService.listAllDevices());
        System.out.println("Returning Devices:");
        return "devices";
    }

    @RequestMapping("device/{id}")
    public String showDevice(@PathVariable Integer id, Model model){
        model.addAttribute("device", DeviceService.getDeviceById(id));
        return "deviceshow";
    }


//
//    @RequestMapping(value = "Station", method = RequestMethod.POST)
//    public String saveDevice(Station device){
//
//        DeviceService.saveDevice(device);
//
//        return "redirect:/Station/" + device.getId();
//    }

}
