package com.itlab2017;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/testapi")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {

        return "test complete";
    }
}