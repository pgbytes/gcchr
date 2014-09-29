package com.gcchr.system.core.configuration.akka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorSystem;

@Configuration
@Lazy
@ComponentScan(basePackages = {"com.gcchr.system.core.configuration.akka", "com.gcchr.system.core.actor"})
public class AkkaApplicationConfiguration
{
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SpringExtension springExtension;

    /**
     * Actor system singleton for this application
     */
    @Bean
    public ActorSystem actorSystem()
    {
        ActorSystem actorSystem = ActorSystem.create("AkkaTaskProcessing", akkaConfiguration());

        //Initialize the application context in the Akka Spring Extension
        this.springExtension.initialize(applicationContext);
        return actorSystem;
    }

    /**
     * Read configuration from application.conf file
     */
    @Bean
    public Config akkaConfiguration()
    {
        return ConfigFactory.load();
    }
}
