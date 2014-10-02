package com.gcchr.system.dal.model;

import java.util.Date;

import com.sun.istack.internal.Nullable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Staff extends User
{
    public Staff(String gcchr_id, String firstName, @Nullable String middleName, String lastName, Date dob, UserType userType)
    {
        super(gcchr_id, firstName, middleName, lastName, dob, userType);
    }
}
