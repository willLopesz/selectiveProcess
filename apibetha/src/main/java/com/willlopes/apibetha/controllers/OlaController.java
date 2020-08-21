package com.willlopes.apibetha.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * OlaController
 */
@RestController
public class OlaController {

    @GetMapping(value="/hello")
    public String hellowWord() {
        return "Ola Mundo! - Agora vai!";
    }
    

    
}