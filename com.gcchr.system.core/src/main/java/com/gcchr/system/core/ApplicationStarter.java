package com.gcchr.system.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.gcchr.system")
@EnableAutoConfiguration
@PropertySource("classpath:/application.properties")
public class ApplicationStarter implements CommandLineRunner
{
    public static void main(String[] args)
    {
        SpringApplication.run(ApplicationStarter.class, args);
    }

    @Override public void run(String... strings) throws Exception
    {

    }
}
