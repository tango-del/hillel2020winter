package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentGenerator {
    public static List<Student> studentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(UUID.randomUUID(), "Ivan", "Ivanov"));
        students.add(new Student(UUID.randomUUID(), "Petr", "Petrov"));
        students.add(new Student(UUID.randomUUID(), "Sidr", "Sidorov"));

        return students;
    }

    public static Student getStudent(String firstName, String lastName) {
        return new Student(UUID.randomUUID(), firstName, lastName);
    }
}
