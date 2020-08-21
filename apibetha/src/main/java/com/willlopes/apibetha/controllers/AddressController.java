package com.willlopes.apibetha.controllers;

import java.util.Collection;
import java.util.List;

import com.willlopes.apibetha.models.AddressModel;
import com.willlopes.apibetha.services.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/address")
public class AddressController {
    
    @Autowired
    private AddressService addressService;

    @GetMapping
    public Collection<AddressModel> getAllAddress(){
        return addressService.listAddress();
    }

    @PostMapping
    public ResponseEntity<?> saveAllAddress(@RequestBody List<AddressModel> addresses) {
        System.out.println(addresses);
        return addressService.saveAllAddress(addresses);
    
    }

}