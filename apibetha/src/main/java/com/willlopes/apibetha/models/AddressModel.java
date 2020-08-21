package com.willlopes.apibetha.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AddressModel
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean type;
    private String full;
    private String address;
    private String number;
    private String district;
    private String city;
    private String state;
    private String country;
    private String cep;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel clientId;

}