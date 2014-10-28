package com.gcchr.system.core.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcchr.system.dal.model.Patient;
import com.gcchr.system.dal.model.UserAccount;
import com.gcchr.system.dal.model.UserRole;
import com.gcchr.system.dal.service.PatientService;
import com.gcchr.system.dal.service.UserAccountService;

@Service
public class UserManagementService
{
    private final UserAccountService userAccountService;
    private final PatientService     patientService;

    @Autowired
    public UserManagementService(UserAccountService userAccountService, PatientService patientService)
    {
        this.userAccountService = userAccountService;
        this.patientService = patientService;
    }

    public Patient createOrUpdatePatient(Patient patient)
    {
        patient = this.patientService.saveOrUpdate(patient);

        return null;
    }

    public void createSamplePatient()
    {
        Patient samplePatient = this.patientService.savePatient(this.patientService.createSamplePatient());
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(samplePatient.getFirstName());
        userAccount.setPassword("123456");
        userAccount.setUserRoles(Arrays.asList(UserRole.PATIENT));
        userAccount.setUser(samplePatient);
        this.userAccountService.saveCredentials(userAccount);
    }
}
