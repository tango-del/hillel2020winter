package Interfaces;

import Tables.Student;

import java.sql.SQLException;

/**
 * Интерфейс в котором релизованы методы для работы с базой данных
 */
public interface SqlWork {
    void createConnection() throws ClassNotFoundException, SQLException;
    void addNewRowStudent(Student student) throws SQLException;
    void deleteRawStudentByID(int students_id) throws SQLException;
    void outputAllStudentsIdAndName() throws SQLException;
    void closeConnection() throws SQLException;
}
