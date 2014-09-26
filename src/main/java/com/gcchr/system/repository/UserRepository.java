package com.gcchr.system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcchr.system.model.User;

public interface UserRepository extends MongoRepository<User, String>
{
}
