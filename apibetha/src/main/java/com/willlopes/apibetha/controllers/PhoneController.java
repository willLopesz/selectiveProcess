package com.willlopes.apibetha.controllers;

import java.util.List;

import com.willlopes.apibetha.models.PhoneModel;
import com.willlopes.apibetha.services.PhoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping
    public ResponseEntity<?> saveAllPhones(@RequestBody List<PhoneModel> phones) {

        return phoneService.saveAllPhones(phones);
    
    }

}