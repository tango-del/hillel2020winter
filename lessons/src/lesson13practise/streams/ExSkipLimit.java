package lesson13practise.streams;

import lesson13practise.Sex;
import lesson13practise.User;
import lesson13practise.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class ExSkipLimit {
    public static void main(String[] args) {
        List<User> users = UserService.getUserList();
        users.forEach(User::print);
        System.out.println("------------");

        List<String> userFullName = users.stream()
                .skip(3)
                .limit(10)
                .filter(u -> u.getSex().equals(Sex.FEMALE))
                .skip(3)
                .map(u -> {
                    u.setFullName(u.getFirstName() + " " + u.getLastName());
                    return u;
                })
                .map(User::getFullName)
                .collect(Collectors.toList());

        userFullName.forEach(System.out::println);
    }
}
