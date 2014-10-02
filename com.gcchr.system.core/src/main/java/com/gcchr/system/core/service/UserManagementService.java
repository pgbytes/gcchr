package com.gcchr.system.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcchr.system.dal.model.Login;
import com.gcchr.system.dal.model.Patient;
import com.gcchr.system.dal.model.UserRole;
import com.gcchr.system.dal.service.LoginService;
import com.gcchr.system.dal.service.PatientService;

@Service
public class UserManagementService
{
    private final LoginService   loginService;
    private final PatientService patientService;

    @Autowired
    public UserManagementService(LoginService loginService, PatientService patientService)
    {
        this.loginService = loginService;
        this.patientService = patientService;
    }

    public void createSamplePatient()
    {
        Patient samplePatient = this.patientService.savePatient(this.patientService.createSamplePatient());
        Login login = new Login();
        login.setUsername(samplePatient.getFirstName());
        login.setPassword("123456");
        login.setUserRole(UserRole.PATIENT);
        login.setUser(samplePatient);
        this.loginService.saveCredentials(login);
    }
}
