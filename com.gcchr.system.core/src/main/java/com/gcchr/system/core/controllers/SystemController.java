package com.gcchr.system.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcchr.system.core.service.AuthenticationService;
import com.gcchr.system.core.service.UserManagementService;
import com.gcchr.system.dal.model.Patient;
import com.gcchr.system.dal.model.UserAccount;
import com.gcchr.system.dal.service.PatientService;

@RestController
@RequestMapping("/system")
public class SystemController
{
    private final PatientService        patientService;
    private final UserManagementService userManagementService;
    private final AuthenticationService authenticationService;

    @Autowired
    public SystemController(PatientService patientService, UserManagementService userManagementService, AuthenticationService authenticationService)
    {
        this.patientService = patientService;
        this.userManagementService = userManagementService;
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/alive", method = RequestMethod.GET)
    public String controllerStatusCheck()
    {
        return "All is good";
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<Patient> getAllUsers()
    {
        return this.patientService.findAll();
    }

    @RequestMapping(value = "/savesamplepatient", method = RequestMethod.PUT)
    public void saveSamplePatient()
    {
        this.userManagementService.createSamplePatient();
    }

    @RequestMapping(value = "/logins", method = RequestMethod.GET)
    public List<UserAccount> getAllLogins()
    {
        return this.authenticationService.fetchAllLogins();
    }
}
