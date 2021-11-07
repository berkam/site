package site.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credential_id", referencedColumnName = "login")
    private Credential credential;
    private BigDecimal money;
//    @OneToOne(optional = false, mappedBy = "person")
//    private Basket basket;
//    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "person_id")
//    private Address address;

    public User(Credential credential, BigDecimal money) {
        this.credential = credential;
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(credential, user.credential)
                && Objects.equals(money, user.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, credential, money);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", credential=" + credential.getLogin() +
                ", money=" + money +
                '}';
    }
}
