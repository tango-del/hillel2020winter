import Examples.Say;
import Examples.Student;
import Examples.StudentSay;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentSayTest {

    @BeforeEach
    public void before() {
        System.out.println("before");
    }

    @AfterEach
    public void after() {
        System.out.println("after");
    }

    @Test
    public void testStudentSay() {
        Student student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Ivanov");

        new StudentSay().StudentSay(student, 4, new Say());
        new StudentSay().StudentSay(student, 6, new Say());

        System.out.println(student.getFullName());
    }

    @Test
    public void testStudentSayMock() {
        Student student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Ivanov");

        Say mock = mock(Say.class);
        when(mock.sayGav()).thenReturn("Gav Gav mock");
        when(mock.sayHello()).thenReturn("Hello mock");

        new StudentSay().StudentSay(student, 4, mock);
        new StudentSay().StudentSay(student, 6, mock);

        Student b = mock(Student.class);
        when(b.getFullName()).thenReturn("new name");
        when(b.getFirstName()).thenReturn("fn");
        when(b.getLastName()).thenReturn("ln");
        b.setFirstName("Alex");
        b.setLastName("Stepurko");
        System.out.println(b.getFirstName());
        System.out.println(b.getLastName());
        System.out.println(b.getFullName());
    }
}