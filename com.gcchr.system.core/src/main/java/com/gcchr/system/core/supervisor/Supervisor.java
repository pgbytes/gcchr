package com.gcchr.system.core.supervisor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gcchr.system.common.dto.SamplePatientUser;
import com.gcchr.system.core.configuration.akka.SpringExtension;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.routing.ActorRefRoutee;
import akka.routing.Routee;
import akka.routing.Router;
import akka.routing.SmallestMailboxRoutingLogic;
import lombok.extern.slf4j.Slf4j;

@Component
@Scope("prototype")
@Slf4j
public class Supervisor extends UntypedActor
{
    private final SpringExtension springExtension;

    private Router router;

    @Autowired
    public Supervisor(SpringExtension springExtension)
    {
        this.springExtension = springExtension;
    }

    @Override
    public void preStart() throws Exception
    {
        log.info("Starting up Supervisor");
        List<Routee> routees = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            ActorRef actor = getContext().actorOf(springExtension.props("patientActor"));
            getContext().watch(actor);
            routees.add(new ActorRefRoutee(actor));
        }
        this.router = new Router(new SmallestMailboxRoutingLogic(), routees);
        super.preStart();
    }

    @Override public void onReceive(Object message) throws Exception
    {
        if (message instanceof SamplePatientUser)
        {
            router.route(message, getSender());
        }
        else if (message instanceof Terminated)
        {
            //Re-read actors if one failed
            router = router.removeRoutee(((Terminated) message).actor());
            ActorRef actor = getContext().actorOf(springExtension.props("patientActor"));
            getContext().watch(actor);
            router = router.addRoutee(new ActorRefRoutee(actor));
        }
        else
        {
            log.error("Unable to handle message {}", message);
        }
    }

    @Override
    public void postStop() throws Exception
    {
        log.info("Shutting down supervisor");
        super.postStop();
    }
}
