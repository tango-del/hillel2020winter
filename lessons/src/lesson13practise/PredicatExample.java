package lesson13practise;

import java.util.function.Predicate;

public class PredicatExample {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setAge(34);
        user.setSex(Sex.MALE);

        Predicate<User> isAdult = (u) -> u.getAge() > 18; // true
        Predicate<User> isChild = (u) -> u.getAge() <= 18; // false
        Predicate<User> isMale = (u) -> u.getSex().equals(Sex.MALE);
        Predicate<User> isFemale = (u) -> u.getSex().equals(Sex.FEMALE);

        System.out.println(isAdult.test(user));
        System.out.println(isAdult.and(isMale).or(isChild).test(user));
        // user.getSex().equals(Sex.MALE) && u.getAge() > 18
        System.out.println(isAdult.and(isFemale).test(user));
        // user.getSex().equals(Sex.MALE) || u.getAge() > 18
    }
}
