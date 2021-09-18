package site.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Credential {
    @Id
    private String login;
    private String password;

    public Credential(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
