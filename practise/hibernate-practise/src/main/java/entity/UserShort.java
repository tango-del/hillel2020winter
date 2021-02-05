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
public class UserShort {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;
}
