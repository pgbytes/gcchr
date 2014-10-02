package com.gcchr.system.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcchr.system.dal.model.Patient;
import com.gcchr.system.dal.service.PatientService;

@RestController
@RequestMapping("/system")
public class SystemController
{
    private final PatientService patientService;

    @Autowired
    public SystemController(PatientService patientService)
    {
        this.patientService = patientService;
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
        this.patientService.saveSamplePatient();
    }
}
