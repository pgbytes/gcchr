package com.gcchr.system.core;

import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.gcchr.system.common.dto.SamplePatientUser;
import com.gcchr.system.core.configuration.akka.SpringExtension;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ComponentScan("com.gcchr.system")
@EnableAutoConfiguration
@PropertySource("classpath:/application.properties")
public class ApplicationStarter implements CommandLineRunner
{
    public static void main(String[] args) throws InterruptedException
    {
        ApplicationContext context = SpringApplication.run(ApplicationStarter.class, args);

        ActorSystem actorSystem = context.getBean(ActorSystem.class);

        log.info("Starting the actor system");

        SpringExtension extension = context.getBean(SpringExtension.class);

        //Use the Spring Extension to create props for a named actor bean
        ActorRef supervisor = actorSystem.actorOf(extension.props("supervisor").withMailbox("akka.priority-mailbox"));

        for (int i = 1; i < 1000; i++)
        {
            SamplePatientUser spu = new SamplePatientUser(new Random().nextInt(99), "gcchr_" + i, "patient_" + i);
            supervisor.tell(spu, null);
        }

        //Poison pill will be queued with a priority of 100 as the last message
        supervisor.tell(PoisonPill.getInstance(), null);

        while (!supervisor.isTerminated())
        {
            Thread.sleep(100);
        }

        log.info("Created a lot of sample patient objects");

        log.info("Shutting down...");

        actorSystem.shutdown();
        actorSystem.awaitTermination();
    }

    @Override public void run(String... strings) throws Exception
    {

    }
}
