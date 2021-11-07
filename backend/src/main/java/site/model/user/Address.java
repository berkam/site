//package site.model.user;
//
//import com.sun.istack.NotNull;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import org.springframework.data.jpa.domain.AbstractPersistable;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
//import java.util.Collection;
//
//@Data
//@Entity
//@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//public class Address extends AbstractPersistable<Long> {
//    @NotNull
//    private String sector;
//    @NotNull
//    private String system;
//    @NotNull
//    private String planet;
//    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
//    private Collection<Person> tenants;
//
//    public Address(@NotNull String sector, @NotNull String system, @NotNull String planet) {
//        this.sector = sector;
//        this.system = system;
//        this.planet = planet;
//    }
//}
