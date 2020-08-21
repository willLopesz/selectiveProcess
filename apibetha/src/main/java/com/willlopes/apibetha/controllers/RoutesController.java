package com.willlopes.apibetha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoutesController {

    @RequestMapping("/")
    public String homeRoute(){
        return "index";
    }

}