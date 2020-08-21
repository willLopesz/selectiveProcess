package com.willlopes.apibetha.controllers;

import com.willlopes.apibetha.models.ClientModel;
import com.willlopes.apibetha.models.UserModel;
import com.willlopes.apibetha.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<?> saveClient(@RequestBody ClientModel client){
        
        return clientService.saveNewClient(client);

    }

    @PostMapping("/list")
    public ResponseEntity<?> listAll(@RequestBody UserModel insertBy){
        return clientService.getListAll(insertBy);

    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleClient(@PathVariable Long id){
        System.out.println(id);
        return clientService.deleteClient(id);

    }

}