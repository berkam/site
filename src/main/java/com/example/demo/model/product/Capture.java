package com.example.demo.model.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Capture extends Product {
    private int maxObjectSize;
    private int range;

    public Capture(String name, BigDecimal price, Integer volume, ProductType productType, int maxObjectSize, int range) {
        super(name, price, volume, productType);
        this.maxObjectSize = maxObjectSize;
        this.range = range;
    }
}
