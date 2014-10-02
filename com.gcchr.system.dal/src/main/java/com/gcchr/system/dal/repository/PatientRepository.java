package com.gcchr.system.dal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcchr.system.dal.model.Patient;

public interface PatientRepository extends MongoRepository<Patient, String>
{
}
