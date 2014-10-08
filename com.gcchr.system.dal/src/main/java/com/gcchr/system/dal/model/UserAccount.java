package com.gcchr.system.dal.model;

import java.util.List;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAccount extends AbstractDocument
{
    @Indexed(unique = true, direction = IndexDirection.ASCENDING)
    private String         username;
    private String         password;
    private String         status;
    private Boolean        enabled;
    private List<UserRole> userRoles;

    @DBRef
    private User user;
}
