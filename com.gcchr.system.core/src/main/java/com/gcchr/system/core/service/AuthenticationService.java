package com.gcchr.system.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcchr.system.dal.model.Login;
import com.gcchr.system.dal.service.LoginService;

@Service
public class AuthenticationService
{
    private final LoginService loginService;

    @Autowired
    public AuthenticationService(LoginService loginService)
    {
        this.loginService = loginService;
    }

    public List<Login> fetchAllLogins()
    {
        return this.loginService.fetchAllLogins();
    }
}
