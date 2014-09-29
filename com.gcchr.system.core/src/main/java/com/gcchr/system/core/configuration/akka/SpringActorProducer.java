package com.gcchr.system.core.configuration.akka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;

public class SpringActorProducer implements IndirectActorProducer
{
    private final ApplicationContext applicationContext;
    private final String             actorBeanName;

    @Autowired
    public SpringActorProducer(ApplicationContext applicationContext, String actorBeanName)
    {
        this.applicationContext = applicationContext;
        this.actorBeanName = actorBeanName;
    }

    @Override public Actor produce()
    {
        return (Actor) applicationContext.getBean(actorBeanName);
    }

    @Override public Class<? extends Actor> actorClass()
    {
        return (Class<? extends Actor>) applicationContext.getType(actorBeanName);
    }
}
