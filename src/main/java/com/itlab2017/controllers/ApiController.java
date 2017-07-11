package com.itlab2017.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {


    @RequestMapping("/devices")
    @PostMapping
    public int devices(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return 2;
    }

}