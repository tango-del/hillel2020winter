import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTestRunner {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new FileSystemXmlApplicationContext("practise/spring-xml-practise/src/main/resources/spring-bean.xml");

        Object obj1 = context.getBean("test");
        System.out.println("-----> 1");
        Thread.sleep(1000);
        Object obj2 = context.getBean("test");
        System.out.println("-----> 2");
        Thread.sleep(1000);
        Object obj3 = context.getBean("test");

        ((Test) obj1).print();
        ((Test) obj2).print();
        ((Test) obj3).print();
    }
}
