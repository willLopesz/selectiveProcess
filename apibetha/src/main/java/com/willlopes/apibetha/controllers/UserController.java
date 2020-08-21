package com.willlopes.apibetha.controllers;

import com.willlopes.apibetha.models.UserModel;
import com.willlopes.apibetha.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserModel user){

        return userService.saveNewUser(user);

    }

    @PostMapping(value="/login")
    public ResponseEntity<?> login(@RequestBody UserModel user) {

        return userService.login(user);
    
    }
    

}