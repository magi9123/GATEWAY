package com.repositories;

import com.models.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {

    @Query("select * from client c where c.name = :p")
    Client findByClientId(@Param("p") String currency);
}
