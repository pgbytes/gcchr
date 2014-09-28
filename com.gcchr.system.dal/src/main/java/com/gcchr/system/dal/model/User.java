package com.gcchr.system.dal.model;

import java.util.Date;

import com.sun.istack.internal.Nullable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class User extends AbstractDocument
{
    private final String gcchr_id;

    private final String firstName;

    private String middleName;

    private final String lastName;

    private final Date dob;

    private Contact contact;

    public User(String gcchr_id, String firstName, @Nullable String middleName, String lastName, Date dob)
    {
        this.gcchr_id = gcchr_id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
    }
}
