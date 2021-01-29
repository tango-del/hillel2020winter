import DB_University.Connect;
import Tables.Student;

import java.sql.*;

/**
 * Программа подключается к MYSQL серверу с помощью JDBC драйвера. Настроена на добавление\удаление сущностей у
 * таблицы Students, а так же вывод в консоль всех id и full_name. Добавляемые и получаемые данные записываются
 * в экземплярах класса Student которой построен с помощью паттерна Builder. Окончание работы программы закрывает подключение к серверу.
 */
public class StartProgram {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connect connect = new Connect("jdbc:mysql://localhost:3306/university", "root", "Sobik2010");

        connect.createConnection();

        Student student = new Student.Builder().setFullName("TestName").setGroup(6).setYearJoin(2019).build();

        connect.addNewRowStudent(new Student.Builder().setFullName("Test Name").setYearJoin(2011).build());

        connect.addNewRowStudent(student);

        connect.deleteRawStudentByID(20);

        connect.outputAllStudentsIdAndName();

        connect.closeConnection();
    }
}
