package com.gcchr.system.dal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcchr.system.dal.model.Physician;

public interface PhysicianRepository extends MongoRepository<Physician, String>
{
}
