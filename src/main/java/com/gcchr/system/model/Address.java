package com.gcchr.system.model;

import lombok.Data;

@Data
public class Address
{
    private final AddressType addressType;
    private final String      street;
    private       String      street2;
    private final int         zipcode;
    private final String      city;
    private       String      state;
    private       String      country;
}
