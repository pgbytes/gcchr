package com.gcchr.system.dal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcchr.system.dal.model.Patient;

public interface PatientRepository extends MongoRepository<Patient, String>
{

    Patient findByGcchrId(String gcchrId);

    List<Patient> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);
}
