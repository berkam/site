package site.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
public class Credential {

    @Id
    private String login;
    private String password;
    @OneToOne(mappedBy = "credential")
    private Person person;

    public Credential(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", person=" + person.getId() +
                '}';
    }
}
