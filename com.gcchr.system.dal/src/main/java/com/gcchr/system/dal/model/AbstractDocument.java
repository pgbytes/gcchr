package com.gcchr.system.dal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public abstract class AbstractDocument
{
    @JsonIgnore
    private String id;
}
