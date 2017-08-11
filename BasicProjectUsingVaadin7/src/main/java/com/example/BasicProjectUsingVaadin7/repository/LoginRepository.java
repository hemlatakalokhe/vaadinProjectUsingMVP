package com.example.BasicProjectUsingVaadin7.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.BasicProjectUsingVaadin7.model.LoginEntity;

public interface LoginRepository  extends CrudRepository<LoginEntity	, Integer>{

}
