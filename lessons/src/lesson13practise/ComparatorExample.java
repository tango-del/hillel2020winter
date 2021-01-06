package lesson13practise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Ivan", "", 12));
        userList.add(new User("Sveta", "", 14));
        userList.add(new User("Anna", "", 34));
        userList.add(new User("Alex", "1", 12));
        userList.add(new User("Alex", "2", 43));
        userList.add(new User("Alex", "3", 34));
        userList.add(new User("Petr", "", 44));


        Comparator<User> userComparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        };

        Comparator<User> ageComparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        };

        userList.forEach(u -> System.out.println(u));
        System.out.println();

        //userList.sort(userComparator.thenComparing(ageComparator));
        userList.sort(ageComparator.thenComparing(userComparator));

        userList.forEach(u -> System.out.println(u));
    }
}
