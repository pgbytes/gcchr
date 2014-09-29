package com.gcchr.system.core.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gcchr.system.common.dto.SamplePatientUser;
import com.gcchr.system.dal.service.UserService;

import akka.actor.UntypedActor;
import lombok.extern.slf4j.Slf4j;

@Component
@Scope("prototype")
@Slf4j
public class PatientActor extends UntypedActor
{
    private final UserService userService;

    @Autowired
    public PatientActor(UserService userService)
    {
        this.userService = userService;
    }

    @Override public void onReceive(Object samplePatient) throws Exception
    {
        SamplePatientUser patient = (SamplePatientUser) samplePatient;
        this.userService.saveSamplePatient(patient.getGcchrId(), patient.getName());
        log.info("Sample Patient Created with gcchrId: {}, name: {}", patient.getGcchrId(), patient.getName());
    }
}
