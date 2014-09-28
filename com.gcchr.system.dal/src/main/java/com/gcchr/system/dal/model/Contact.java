package com.gcchr.system.dal.model;

import java.util.List;

import lombok.Data;

@Data
public class Contact
{
    private List<Phone>   phones;
    private List<Email>   emails;
    private List<Address> addresses;
}
