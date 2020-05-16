package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Basket {
    private @Id
    @GeneratedValue
    Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;
}
