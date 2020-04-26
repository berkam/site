package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Map;

@Data
@Entity
@Table(name = "Products")
@NoArgsConstructor
public class Product {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private BigDecimal price;
    private Integer volume;
    private ProductType productType;
    private Map<String, Integer> specification;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, BigDecimal price, Integer volume,
                   ProductType productType, Map<String, Integer> specification) {
        this.name = name;
        this.price = price;
        this.volume = volume;
        this.productType = productType;
        this.specification = specification;
    }
}
