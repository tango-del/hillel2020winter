package lesson13practise.streams;

import lesson13practise.Sex;
import lesson13practise.User;
import lesson13practise.service.UserService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExMap {
    public static void main(String[] args) {
        List<User> users = UserService.getUserList();
        users.forEach(User::print);
        System.out.println("------------");

        List<Integer> usersAges = users.stream()
                .filter(u -> u.getSex().equals(Sex.FEMALE))
                .map(User::getAge)
                .collect(Collectors.toList());

        System.out.println(usersAges);
        System.out.println("------------");

        Comparator<User> ageComparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        };

        List<User> userTest = users.stream()
                .filter(u -> u.getSex().equals(Sex.FEMALE))
                .map(u -> {
                    u.setFullName(u.getFirstName() + " " + u.getLastName());
                    return u;
                })
                .collect(Collectors.toList());

        userTest.forEach(u -> System.out.println(u.getFullName()));
        System.out.println("------------");

        List<String> userFullName = users.stream()
                .filter(u -> u.getSex().equals(Sex.FEMALE))
                .map(u -> {
                    u.setFullName(u.getFirstName() + " " + u.getLastName());
                    return u;
                })
                .map(User::getFullName)
                .collect(Collectors.toList());

        userFullName.forEach(System.out::println);
    }
}
