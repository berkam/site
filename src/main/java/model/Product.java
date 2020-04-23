package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Product {
    private @Id
    @GeneratedValue
    Long id;
    String name;
    BigDecimal price;
    ProductType type;
    Integer level;
}
