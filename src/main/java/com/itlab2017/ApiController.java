package com.itlab2017;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.itlab2017.Business.Device;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.javascript.JSObject;

@RestController
@RequestMapping("/api")
public class ApiController {
    @RequestMapping("/getdevicelist")
    public ArrayList<Device> getdevicelist(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        ArrayList<Device> list = new ArrayList<>();
        for (int i = 0; i<10; i++){
            Device device = new Device();
            device.id = i;
            device.name = "device " + String.valueOf(i);
            list.add(device);
        }
        return list;
    }
    @RequestMapping("/test")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {

        return "test compslete";
    }

}