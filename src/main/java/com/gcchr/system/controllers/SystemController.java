package com.gcchr.system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gcchr.system.model.User;
import com.gcchr.system.service.UserService;

@RestController
@RequestMapping("/system")
public class SystemController
{
    private final UserService userService;

    @Autowired
    public SystemController(UserService userService)
    {
        this.userService = userService;
    }

    @RequestMapping(value = "/alive", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String controllerStatusCheck()
    {
        return "All is good";
    }

    @RequestMapping(value = "/getallusers", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers()
    {
        return this.userService.findAll();
    }

    @RequestMapping(value = "savesamplepatient", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void saveSamplePatient()
    {
        this.userService.saveSamplePatient();
    }
}
