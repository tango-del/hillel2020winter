package lesson7Test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//
//        String first = "First Person";
//        String second = "Second Person";
//
//        list.add(first);
//        list.add(second);
//
//        System.out.println(list);
//
//        boolean remove = list.remove(first);
//
//        System.out.println(remove);
//        String person = list.get(0);
//        System.out.println(person);

        StringList stringList = new StringList();

        stringList.addString("First");
        stringList.addString("Second");
        stringList.listArgs();
    }
}
