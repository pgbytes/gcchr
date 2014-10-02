package com.gcchr.system.dal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcchr.system.dal.repository.LoginRepository;

@Service
public class LoginService
{
    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository)
    {
        this.loginRepository = loginRepository;
    }

}
