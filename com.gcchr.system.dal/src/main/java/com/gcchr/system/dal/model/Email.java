package com.gcchr.system.dal.model;

import lombok.Data;

@Data
public class Email
{
    private final EmailType emailType;
    private final String    emailAddress;
}