package com.gcchr.system.dal.model;

import java.util.Date;

import com.sun.istack.internal.Nullable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class SalariedUser extends User
{
    public SalariedUser(String gcchr_id, String firstName, @Nullable String middleName, String lastName, Date dob, UserType userType, Salary salary)
    {
        super(gcchr_id, firstName, middleName, lastName, dob, userType);
        this.salary = salary;
    }

    private final Salary salary;
}
