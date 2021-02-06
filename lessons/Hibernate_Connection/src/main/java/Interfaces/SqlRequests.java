package Interfaces;

import entities.Student;
import org.hibernate.Session;

public interface SqlRequests {
    void addNewEntityStudent(Session session , Student student);
    void deleteEntityStudentByID(Session session, int students_id);
    void outputAllStudentsIdAndName(Session session);
}
