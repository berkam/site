package com.example.demo.model.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
public class Droid extends Product{
    private int power;

    public Droid(String name, BigDecimal price, Integer volume, ProductType productType, int power) {
        super(name, price, volume, productType);
        this.power = power;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "power=" + power +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", productType=" + productType +
                '}';
    }
}
