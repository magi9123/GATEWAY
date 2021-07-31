package com.repositories;

import com.models.Currency;
import com.models.user.UserAbstract;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCurrencyRepository extends CrudRepository<UserAbstract, String> {

    @Query("select * from currency c where c.name = :p")
    Currency findByCurrency(@Param("p") String currency);
}
