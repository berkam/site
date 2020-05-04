package com.example.demo.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

public class Address extends AbstractPersistable<Long> {
    private String sector;
    private String system;
    private String planet;
}
