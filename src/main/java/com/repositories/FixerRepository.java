package com.repositories;

import com.models.FixerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixerRepository extends CrudRepository<FixerModel, Long> {
}
