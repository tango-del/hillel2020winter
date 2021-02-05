package Interfaces;

import Tables.Student;

import java.sql.SQLException;

/**
 * Интерфейс в котором релизованы методы для работы с базой данных
 */
public interface Connection {
    void createConnection() throws ClassNotFoundException, SQLException;
    void closeConnection() throws SQLException;
}
