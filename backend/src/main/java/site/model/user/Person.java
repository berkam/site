package site.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Person extends AbstractPersistable<Long> {

    @ManyToOne
    @JoinColumn(name = "credential_id")
    private Credential credential;
    private BigDecimal money;
    @OneToOne(optional = false, mappedBy = "person")
    private Basket basket;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Address address;

    public Person(String login, String password, BigDecimal money, Basket basket, Address address) {
        this.money = money;
        this.basket = basket;
        this.address = address;
    }
}
