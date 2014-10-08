package com.gcchr.system.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcchr.system.dal.model.UserAccount;
import com.gcchr.system.dal.service.UserAccountService;

@Service
public class AuthenticationService
{
    private final UserAccountService userAccountService;

    @Autowired
    public AuthenticationService(UserAccountService userAccountService)
    {
        this.userAccountService = userAccountService;
    }

    public List<UserAccount> fetchAllLogins()
    {
        return this.userAccountService.fetchAllLogins();
    }
}
