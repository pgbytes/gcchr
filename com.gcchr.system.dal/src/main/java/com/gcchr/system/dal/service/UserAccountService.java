package com.gcchr.system.dal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcchr.system.dal.model.UserAccount;
import com.gcchr.system.dal.repository.UserAccountRepository;

@Service
public class UserAccountService
{
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository)
    {
        this.userAccountRepository = userAccountRepository;
    }

    public void saveCredentials(UserAccount userAccount)
    {
        this.userAccountRepository.save(userAccount);
    }

    public List<UserAccount> fetchAllLogins()
    {
        return this.userAccountRepository.findAll();
    }

    public UserAccount findByUsername(final String username)
    {
        return this.userAccountRepository.findByUsername(username);
    }

    public List<UserAccount> findByUsernameAndPassword(final String username, final String password)
    {
        return this.userAccountRepository.findByUsernameAndPassword(username, password);
    }

}
