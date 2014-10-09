package com.gcchr.system.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.gcchr.system.core.service.AuthenticationService;

@Configuration
@EnableWebMvcSecurity
//@EnableGlobalMethodSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Autowired
    private SecurityProperties security;

    @Autowired
    private AuthenticationService authenticationService;

    //    //@Override
    //    protected void configure(HttpSecurity http) throws Exception
    //    {
    //        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    //    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(this.authenticationService);

        //        auth.inMemoryAuthentication().withUser("admin").password("admin")
        //                .roles("ADMIN", "USER").and().withUser("user").password("user")
        //                .roles("USER");
    }
}
