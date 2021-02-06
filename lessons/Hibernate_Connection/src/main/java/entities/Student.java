package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Student {
    @Id
    @GeneratedValue
    @Column(name ="students_id")
    private int studentsId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "`group`")
    private int group;

    @Column(name = "year_join")
    private int yearJoin;
}
