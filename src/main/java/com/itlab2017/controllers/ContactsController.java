package com.itlab2017.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactsController {

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String list(Model model) {
        return "contacts";
    }
}
