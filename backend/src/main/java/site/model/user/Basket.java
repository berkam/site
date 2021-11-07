//package site.model.user;
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import org.springframework.data.jpa.domain.AbstractPersistable;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//
//@Data
//@Entity
//@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//public class Basket extends AbstractPersistable<Long> {
//    @OneToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "person_id")
//    private Person person;
//}
//