package com.gcchr.system.dal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcchr.system.dal.model.Login;

public interface LoginRepository extends MongoRepository<Login, String>
{
}
