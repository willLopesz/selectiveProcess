package com.willlopes.apibetha.services;

import java.util.Collection;
import java.util.List;

import com.willlopes.apibetha.models.AddressModel;
import com.willlopes.apibetha.repositories.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Collection<AddressModel> listAddress(){
        return addressRepository.findAll();
    }

    public ResponseEntity<?> saveAllAddress(List<AddressModel> addresses){
        
        System.out.println(addresses);

        var response = addressRepository.saveAll(addresses);

        System.out.println(response);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

}