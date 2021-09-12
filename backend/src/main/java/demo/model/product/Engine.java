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
public class Engine extends Product {
    private int speed;
    private int jump;

    public Engine(String name, BigDecimal price, Integer volume, ProductType productType, int speed, int jump) {
        super(name, price, volume, productType);
        this.speed = speed;
        this.jump = jump;
    }
}
