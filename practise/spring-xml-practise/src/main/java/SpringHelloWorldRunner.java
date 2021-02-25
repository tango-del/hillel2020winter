import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringHelloWorldRunner {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("practise/spring-xml-practise/src/main/resources/spring-bean.xml");

        Teacher t = (Teacher) context.getBean("teacher");
        Student s = (Student) context.getBean("student");

//        System.out.println(t.toString());
//        System.out.println(s.toString());

        SpringHelloWorld springHelloWorld = (SpringHelloWorld) context.getBean("springHelloWorld");

        System.out.println(springHelloWorld.getStudent().toString());

        System.out.println(springHelloWorld.getUser().toString());
    }
}
