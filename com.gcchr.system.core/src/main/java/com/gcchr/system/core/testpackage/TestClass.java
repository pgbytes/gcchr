package com.gcchr.system.core.testpackage;

import com.gcchr.system.dal.model.Patient;
import com.gcchr.system.dal.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaurang on 26/12/14.
 */
@Service
public class TestClass {

    private final PatientService patientService;

    @Autowired
    public TestClass(PatientService patientService) {
        this.patientService = patientService;
    }

    public void CreateSamplePatient() {
        Patient patient = patientService.createSamplePatient();
        patientService.saveOrUpdate(patient);
    }
}
