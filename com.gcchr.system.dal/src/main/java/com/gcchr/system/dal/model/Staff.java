package com.gcchr.system.dal.model;

import java.util.Date;
import java.util.List;

import com.sun.istack.internal.Nullable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Staff extends SalariedUser
{
    public Staff(String gcchr_id, String firstName, @Nullable String middleName, String lastName, Date dob, UserType userType, Salary salary, List<String> responsibilities)
    {
        super(gcchr_id, firstName, middleName, lastName, dob, userType, salary);
        this.responsibilities = responsibilities;
    }

    private final List<String> responsibilities;
}
