package Interfaces;

import entities.Student;

public interface SqlRequests {
    void addNewEntityStudent(Student student);
    void deleteEntityStudentByID(int students_id);
    void outputAllStudentsIdAndName();
}
