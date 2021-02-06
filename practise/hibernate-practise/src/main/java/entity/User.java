package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "pasport_number", unique = true, length = 8)
    private String passport;

    @Column(name = "phone", unique = true, length = 12)
    private String phone;

    private Sex sex;

//    @OneToOne
//    @JoinColumn(name = "id")
//    private Address address;

    @Transient
    private String fullName;
}