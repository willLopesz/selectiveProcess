package com.willlopes.apibetha.services;

import java.util.List;

import com.willlopes.apibetha.models.PhoneModel;
import com.willlopes.apibetha.repositories.PhoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {
    
    @Autowired
    private PhoneRepository phoneRepository;

    public ResponseEntity<?> saveAllPhones(List<PhoneModel> phones){
        
        phoneRepository.saveAll(phones);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

}