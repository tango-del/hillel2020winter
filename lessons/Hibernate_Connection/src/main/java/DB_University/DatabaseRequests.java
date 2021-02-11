package DB_University;

import Interfaces.SqlRequests;
import entities.Student;
import org.hibernate.Query;

public class DatabaseRequests implements SqlRequests {
    private static Query query;
    @Override
    public void addNewEntityStudent(Student student) {
        Connect.session.beginTransaction();
        Connect.session.save(student);
        Connect.session.getTransaction().commit();
    }

    @Override
    public void deleteEntityStudentByID(int students_id) {
        Connect.session.beginTransaction();
        query = Connect.session.createQuery("delete from Student where studentsId = " + students_id);
        query.executeUpdate();
        Connect.session.getTransaction().commit();
    }

    @Override
    public void outputAllStudentsIdAndName() {
        Connect.session.beginTransaction();
        query = Connect.session.createQuery("from StudentShort");
        query.list().forEach(System.out::println);
        Connect.session.getTransaction().commit();
    }
}
