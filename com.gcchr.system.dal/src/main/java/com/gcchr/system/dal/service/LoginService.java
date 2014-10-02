package com.gcchr.system.dal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcchr.system.dal.model.Login;
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

    public void saveCredentials(Login login)
    {
        this.loginRepository.save(login);
    }

    public List<Login> fetchAllLogins()
    {
        return this.loginRepository.findAll();
    }

}
