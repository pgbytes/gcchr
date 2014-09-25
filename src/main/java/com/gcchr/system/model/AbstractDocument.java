package com.gcchr.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public abstract class AbstractDocument
{
    @JsonIgnore
    private String id;
}
