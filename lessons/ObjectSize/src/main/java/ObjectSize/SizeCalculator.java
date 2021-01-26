package ObjectSize;

import org.openjdk.jol.info.ClassLayout;

import java.util.List;

public class SizeCalculator {
    public static void main(String[] args) {
//        System.out.println(ClassLayout.parseClass(Course.class).toPrintable());
//        System.out.println("---------->");
        System.out.println(ClassLayout.parseClass(Person.class).toPrintable());

        Person p = new Person();
        p.setLevel(1);
        p.setName("aaaa");
        p.setGrade('A');
        p.setActive(true);
        p.setSalary(10_000L);
        p.setCourses(List.of(new Course().setName("Java")));

        System.out.println("---------->");
        System.out.println(ClassLayout.parseInstance(p).toPrintable());
    }
}
