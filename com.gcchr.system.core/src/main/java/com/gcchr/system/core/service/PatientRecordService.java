package com.gcchr.system.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcchr.system.dal.model.Patient;
import com.gcchr.system.dal.service.PatientService;

@Service
public class PatientRecordService
{
    private final PatientService patientService;

    @Autowired
    public PatientRecordService(PatientService patientService)
    {
        this.patientService = patientService;
    }

    public Patient createUpdatePatient(Patient patient)
    {
        return patientService.saveOrUpdate(patient);
    }

    public Patient findByGcchrId(String gcchrId)
    {
        return patientService.findByGcchrId(gcchrId);
    }

    public List<Patient> findByPatientName(String firstName, String middleName, String lastName)
    {
        return patientService.findByName(firstName, middleName, lastName);
    }

    public List<Patient> findByPatientNameAndCity(String firstName, String middleName, String lastName, String city)
    {
        return patientService.findByNameAndCity(firstName, middleName, lastName, city);
    }
}
