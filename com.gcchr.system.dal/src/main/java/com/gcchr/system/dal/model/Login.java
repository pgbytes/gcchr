package com.gcchr.system.dal.model;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Login extends AbstractDocument
{
    private String   username;
    private String   password;
    private UserRole userRole;

    @DBRef
    private User user;
}
