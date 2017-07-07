package com.itlab2017;
import java.util.ArrayList;

import com.itlab2017.domain.Device;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @RequestMapping("/devices")
    @PostMapping
    public ArrayList<Device> devices(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        ArrayList<Device> list = new ArrayList<>();
        for (int i = 0; i<10; i++){
            Device device = new Device();
            list.add(device);
        }
        return list;
    }

}