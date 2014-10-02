package com.gcchr.system.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
