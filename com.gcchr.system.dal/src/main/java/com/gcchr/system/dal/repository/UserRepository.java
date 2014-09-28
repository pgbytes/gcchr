package com.gcchr.system.dal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcchr.system.dal.model.User;

public interface UserRepository extends MongoRepository<User, String>
{
}
