package demo.model.product;

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
public class FuelTank extends Product {
    private double capacity;

    public FuelTank(String name, BigDecimal price, Integer volume, ProductType productType, double capacity) {
        super(name, price, volume, productType);
        this.capacity = capacity;
    }
}
