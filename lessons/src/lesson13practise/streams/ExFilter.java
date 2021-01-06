package lesson13practise.streams;

import lesson13practise.Sex;
import lesson13practise.User;
import lesson13practise.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExFilter {
    public static void main(String[] args) {
        List<User> users = UserService.getUserList();

        users.forEach(User::print);
        System.out.println("------------");
        System.out.println(users.stream().filter(u -> u.getSex().equals(Sex.FEMALE)).count());

        List<User> fUsers = users
                .stream()
                .filter(u -> u
                        .getSex()
                        .equals(Sex.FEMALE))
                .collect(Collectors
                        .toList());

        fUsers.forEach(User::print);
        System.out.println("------------");
        Predicate<User> isMale = (u) -> u.getSex().equals(Sex.MALE);
        Predicate<User> isAdult = (u) -> u.getAge() > 18;

        List<User> mUsers = users.stream()
                .filter(isMale)
                .collect(Collectors.toList());

        mUsers.forEach(User::print);
        System.out.println("------------");

        List<User> adultMaleUsers = users
                .stream()
                .filter(isMale.and(isAdult))
                .collect(Collectors.toList());


        adultMaleUsers.forEach(User::print);
    }
}
