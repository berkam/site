package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class Product {
    private @Id
    @GeneratedValue
    Long id;
    String name;
    BigDecimal price;
    ProductType type;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
