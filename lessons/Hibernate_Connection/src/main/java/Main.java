import DB_University.Connect;
import DB_University.DatabaseRequests;
import entities.Student;
import org.hibernate.Session;


public class Main {
    public static void main(String[] args) {
        Session session = Connect.getSession(); // create connection
        DatabaseRequests requests = new DatabaseRequests();

        Student st1 = new Student().setFullName("Test Name").setYearJoin(2023).setGroup(5); // entity example

//        requests.addNewEntityStudent(session, st1);

//        requests.deleteEntityStudentByID(session, 22);

        requests.outputAllStudentsIdAndName(session);


        Connect.closeSession();
    }
}
