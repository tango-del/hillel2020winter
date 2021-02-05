package Interfaces;

import Tables.Student;

import java.sql.SQLException;

public interface SqlRequests {
    void addNewRowStudent(Student student) throws SQLException;
    void deleteRawStudentByID(int students_id) throws SQLException;
    void outputAllStudentsIdAndName() throws SQLException;
}
