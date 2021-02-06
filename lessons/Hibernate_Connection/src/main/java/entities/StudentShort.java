package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Setter
@Getter
@Accessors(chain = true)
public class StudentShort {
    @Id
    @GeneratedValue
    @Column(name ="students_id")
    private int studentsId;

    @Column(name = "full_name")
    private String fullName;

    @Override
    public String toString() {
        return "|ID: " + studentsId + " | name:  " + fullName;
    }
}
