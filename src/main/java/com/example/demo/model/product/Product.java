package com.example.demo.model.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

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
}
