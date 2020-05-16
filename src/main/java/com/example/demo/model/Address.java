package com.example.demo.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.validation.constraints.NotNull;

public class Address extends AbstractPersistable<Long> {
    @NotNull
    private String sector;
    @NotNull
    private String system;
    @NotNull
    private String planet;
}
