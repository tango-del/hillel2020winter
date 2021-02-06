import DB_University.Connect;
import DB_University.DatabaseRequests;
import entities.Student;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;

/*
Интерфейс подключения к бд
класс реализации подключения к бд
интерфейс с запросами в бд
класс с реализацией запросов в бд
метод добавления сущности student
удаление сущности student по id
вывод в консоль студентов в формате id, name
 */

public class Main {
    public static void main(String[] args) {
        //create connection
        Session session = Connect.getSession();
        DatabaseRequests requests = new DatabaseRequests();

        Student st1 = new Student().setFullName("Test Name").setYearJoin(2023).setGroup(5); // entity example

//        requests.addNewEntityStudent(session, st1);

//        requests.deleteEntityStudentByID(session, 22);

        requests.outputAllStudentsIdAndName(session);


        Connect.closeSession();
    }
}
