package com.gcchr.system.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan("com.gcchr.system")
@EnableAutoConfiguration
@PropertySource("classpath:/application.properties")
public class ApplicationStarter extends WebMvcConfigurerAdapter
{
    public static void main(String[] args)
    {
        SpringApplication.run(ApplicationStarter.class, args);
    }


}
