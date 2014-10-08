package com.gcchr.system.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcchr.system.dal.model.UserAccount;
import com.gcchr.system.dal.service.UserAccountService;

@Service
public class AuthenticationService implements UserDetailsService
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

    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException
    {
        UserAccount userAccount = this.userAccountService.findByUsername(username);

        if (userAccount == null)
        {
            return null;
        }

        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(userAccount.getUserRoles().toString());

        String password = userAccount.getPassword();

        return new User(username, password, auth);
    }

}
