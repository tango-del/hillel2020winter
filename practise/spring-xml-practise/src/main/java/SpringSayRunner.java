import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringSayRunner {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new FileSystemXmlApplicationContext("practise/spring-xml-practise/src/main/resources/spring-bean.xml");

        Say obj1 = (Say) context.getBean("say");

        obj1.say();
    }
}
