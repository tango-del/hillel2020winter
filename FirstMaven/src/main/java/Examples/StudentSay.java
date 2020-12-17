package Examples;

public class StudentSay {
    public void StudentSay(Student student, int countDrink, Say say) {
        if (countDrink < 5) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " : say >> " + say.sayHello());
        } else {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " : say >> " + say.sayGav());
        }
    }
}
