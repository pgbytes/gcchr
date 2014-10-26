package com.gcchr.system.dal.model;

import java.util.Date;
import java.util.List;

import com.sun.istack.internal.Nullable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Physician extends SalariedUser
{
    public Physician(String gcchr_id, String firstName, @Nullable String middleName, String lastName, Date dob, UserType userType, Salary salary)
    {
        super(gcchr_id, firstName, middleName, lastName, dob, userType, salary);
    }

    @Nullable
    private List<String> expertise;
}
