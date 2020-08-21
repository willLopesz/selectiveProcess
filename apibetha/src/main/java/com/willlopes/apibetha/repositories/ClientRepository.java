package com.willlopes.apibetha.repositories;

import java.util.List;

import com.willlopes.apibetha.models.ClientModel;
import com.willlopes.apibetha.models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * ClientRepository
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
    
    Boolean existsByDocument(String document);

    List<ClientModel> findAllByInsertBy(UserModel InsertBy);

    @Query(
        value ="SELECT C.id idClient, C.name nameClient, C.document documetClient, C.inser_by insertBy, P.phone phone, A.full full FROM client C INNER JOIN phone P ON P.client_id = C.id AND P.type = 1 INNER JOIN address A ON A.client_id = C.id AND A.type = 1 WHERE C.insert_by = 3",
        nativeQuery = true)
    public List<?> getListAll(String insertBy);

}