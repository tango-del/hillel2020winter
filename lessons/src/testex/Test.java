package testex;

import java.util.Iterator;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> str = new LinkedList<>();
        str.add("one");
        str.add("two");
        str.add("three");
        str.add("four");

        Iterator<String> iterator = str.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("two")) {
                iterator.remove();
            }
            System.out.println(s);
        }
        System.out.println(str);
    }
}
