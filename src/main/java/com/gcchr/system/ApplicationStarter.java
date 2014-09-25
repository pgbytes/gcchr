package com.gcchr.system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:/app-config.properties")
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
