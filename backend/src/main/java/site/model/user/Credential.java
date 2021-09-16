package site.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Credential extends AbstractPersistable<Long> {
    private String login;
    private String password;

    public Credential(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
