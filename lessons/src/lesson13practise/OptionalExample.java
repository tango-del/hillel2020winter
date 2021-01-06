package lesson13practise;

import java.util.Objects;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setAge(18);
        user.setSex(Sex.MALE);
        System.out.println(user);




        //User u = null;
        //u.getAge();

        Optional<User> userOptional = Optional.ofNullable(user);

        userOptional.ifPresent(User::getFirstName);

        if (userOptional.isPresent()) {
            System.out.println(userOptional.get().getAge());
        }
    }
}
