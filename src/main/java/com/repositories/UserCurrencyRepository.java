package com.repositories;

import com.models.user.UserAbstract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCurrencyRepository extends CrudRepository<UserAbstract, String> {
}
