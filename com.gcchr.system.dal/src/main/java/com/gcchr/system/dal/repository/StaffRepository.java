package com.gcchr.system.dal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcchr.system.dal.model.Staff;

public interface StaffRepository extends MongoRepository<Staff, String>
{
}
