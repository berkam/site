package site.model.product;

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
public class Radar extends Product {
    private int range;

    public Radar(String name, BigDecimal price, Integer volume, ProductType productType, int range) {
        super(name, price, volume, productType);
        this.range = range;
    }
}
