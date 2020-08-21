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
 * PhoneModel
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "phone")
public class PhoneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id; 
    
    private boolean type;
    private String name;
    private String phone;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel clientId;

}