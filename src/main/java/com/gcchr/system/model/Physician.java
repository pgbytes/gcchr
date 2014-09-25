package com.gcchr.system.model;

import java.util.Date;

import com.sun.istack.internal.Nullable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Physician extends User
{
    public Physician(String gcchr_id, String firstName, @Nullable String middleName, String lastName, Date dob)
    {
        super(gcchr_id, firstName, middleName, lastName, dob);
    }
}
