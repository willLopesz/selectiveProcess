package com.willlopes.apibetha.services;

import java.util.List;

import com.willlopes.apibetha.error.CustomError;
import com.willlopes.apibetha.models.ClientModel;
import com.willlopes.apibetha.models.UserModel;
import com.willlopes.apibetha.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity<?> saveNewClient(ClientModel client){

        boolean existsUser = clientRepository.existsByDocument(client.getDocument());

        if(existsUser)
            throw new CustomError("Cliente já cadastrado no sistema");

        ClientModel insertClient = clientRepository.save(client);

        return new ResponseEntity<>(insertClient, HttpStatus.OK);

    }

    public ResponseEntity<?> getListAll(UserModel insertBy){


        List<ClientModel> listClient = clientRepository.findAllByInsertBy(insertBy);
        System.out.println(listClient);
        return new ResponseEntity<>(listClient, HttpStatus.OK);

    }

    public ResponseEntity<?> deleteClient(Long id){

        clientRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}