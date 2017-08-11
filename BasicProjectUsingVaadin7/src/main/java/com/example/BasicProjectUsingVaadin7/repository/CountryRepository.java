package com.example.BasicProjectUsingVaadin7.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BasicProjectUsingVaadin7.model.CountryEntity;

@Repository
public interface CountryRepository extends CrudRepository<CountryEntity	, Integer>{

}
