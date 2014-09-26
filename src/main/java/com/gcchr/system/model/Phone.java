package com.gcchr.system.model;

import lombok.Data;

@Data
public class Phone
{
    private final PhoneType phoneType;
    private final String phoneNumber;
}
