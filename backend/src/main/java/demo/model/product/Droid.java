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
public class Droid extends Product {
    private int power;

    public Droid(String name, BigDecimal price, Integer volume, ProductType productType, int power) {
        super(name, price, volume, productType);
        this.power = power;
    }
}
