package com.willlopes.apibetha.repositories;

import com.willlopes.apibetha.models.PhoneModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneModel, Long> {
    
}