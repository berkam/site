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
public class Engine extends Product {
    private int speed;
    private int jump;

    public Engine(String name, BigDecimal price, Integer volume, ProductType productType, int speed, int jump) {
        super(name, price, volume, productType);
        this.speed = speed;
        this.jump = jump;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "speed=" + speed +
                ", jump=" + jump +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", productType=" + productType +
                '}';
    }
}
