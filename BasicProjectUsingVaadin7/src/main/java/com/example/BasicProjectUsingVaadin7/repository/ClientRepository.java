package com.example.BasicProjectUsingVaadin7.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BasicProjectUsingVaadin7.model.ClientEntity;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {

}
