package com.gcchr.system.dal.model;

import lombok.Data;

@Data
public class Phone
{
    private final PhoneType phoneType;
    private final String    phoneNumber;
}
