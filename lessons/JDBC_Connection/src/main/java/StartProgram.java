import DB_University.Connect;
import DB_University.DatabaseRequests;
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
        DatabaseRequests requests = new DatabaseRequests();

        connect.createConnection();

        Student student = new Student.Builder().setFullName("Josh Bloch2").setGroup(12).setYearJoin(2021).build();

//        requests.addNewRowStudent(new Student.Builder().setFullName("Sobik").setYearJoin(2019).setGroup(8).build());

//        requests.addNewRowStudent(student);

//        requests.deleteRawStudentByID(29);

        requests.outputAllStudentsIdAndName();

        connect.closeConnection();
    }
}
