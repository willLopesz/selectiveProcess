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
 * Client
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "client")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id; 

    private String name;
    private String document;

    @ManyToOne
    @JoinColumn(name = "insert_by")
    private UserModel insertBy;

}