package com.willlopes.apibetha.repositories;

import com.willlopes.apibetha.models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByDocument(String document);

    Boolean existsByDocument(String document);

    @Query("SELECT u FROM UserModel u WHERE document = (:document) AND password = (:password)")
    public UserModel getForLogin(@Param("document") String document, @Param("password") String password);    
}