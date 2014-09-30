package com.gcchr.system.core.mailbox;

import com.gcchr.system.common.dto.SamplePatientUser;
import com.typesafe.config.Config;

import akka.actor.ActorSystem;
import akka.dispatch.PriorityGenerator;
import akka.dispatch.UnboundedPriorityMailbox;

public class PriorityMailbox extends UnboundedPriorityMailbox
{
    public PriorityMailbox(ActorSystem.Settings settings, Config config)
    {

        //Create a new PriorityGenerator, lower priority means more important
        super(
                new PriorityGenerator()
                {
                    @Override public int gen(Object message)
                    {
                        if (message instanceof SamplePatientUser)
                        {
                            return ((SamplePatientUser) message).getPriority();
                        }
                        else
                        {
                            //default
                            return 100;
                        }
                    }
                });
    }

}
