package DB_University;

import Interfaces.SqlRequests;
import entities.Student;
import org.hibernate.Query;
import org.hibernate.Session;

public class DatabaseRequests implements SqlRequests {
    private static Query query;
    @Override
    public void addNewEntityStudent(Session session, Student student) {
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    @Override
    public void deleteEntityStudentByID(Session session, int students_id) {
        session.beginTransaction();
        query = session.createQuery("delete from Student where studentsId = " + students_id);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void outputAllStudentsIdAndName(Session session) {
        session.beginTransaction();
        query = session.createQuery("from StudentShort");
        query.list().forEach(System.out::println);
        session.getTransaction().commit();
    }
}
