package site.model.user;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(callSuper = true)
public class Person extends AbstractPersistable<Long> {

    @OneToOne(optional = false, mappedBy = "login")
    @JoinColumn(name = "credential_id")
    private Credential credential;
    private BigDecimal money;
    @OneToOne(optional = false, mappedBy = "person")
    private Basket basket;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Address address;

    public Person(Credential credential, BigDecimal money, Basket basket, Address address) {
        this.credential = credential;
        this.money = money;
        this.basket = basket;
        this.address = address;
    }
}
