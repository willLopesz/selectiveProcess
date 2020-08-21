package com.willlopes.apibetha.services;

import com.willlopes.apibetha.error.CustomError;
import com.willlopes.apibetha.models.UserModel;
import com.willlopes.apibetha.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<?> saveNewUser(UserModel user){
        
        boolean existsUser = userRepository.existsByDocument(user.getDocument());
        
        if(existsUser)
            throw new CustomError("Já existe um usuário com esse CPF!");
        
        UserModel insertUser = userRepository.save(user);
        return new ResponseEntity<>(insertUser, HttpStatus.OK);

    }

    public ResponseEntity<?> login(UserModel user){
        
        boolean existsUser = userRepository.existsByDocument(user.getDocument());

        if(!existsUser)
            throw new CustomError("Usuário não cadastrado!");

        UserModel logged = userRepository.getForLogin(user.getDocument(), user.getPassword());

        if(logged == null)
            throw new CustomError("Senha incorreta!");

        UserModel result = new UserModel();
        result.setId(logged.getId());
        result.setName(logged.getName());

        return new ResponseEntity<>(result , HttpStatus.ACCEPTED);
    }
 
}