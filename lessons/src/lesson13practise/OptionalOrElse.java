package lesson13practise;

import java.util.Optional;

public class OptionalOrElse {
    public static void main(String[] args) {
        User user = new User();
        //User u3 = null;
        //System.out.println(u3);

        User opt = Optional.ofNullable(user).orElse(new User());

        //User opt1 = Optional.ofNullable(u3).orElseGet(() -> print());
        User opt1 = Optional.ofNullable(user).orElseGet(OptionalOrElse::print);

        User opt2 = Optional.ofNullable(user).orElseThrow(() -> new RuntimeException());

        User u1 = Optional.ofNullable(user).map(u -> {
            u.setFirstName("Alex");
            u.setAge(15);
            return u;
        }).get();

        User u2 = Optional.of(u1).filter(u -> u.getAge() > 18).orElse(new User());

        //System.out.println(opt);
        //System.out.println(opt1);
        //System.out.println(opt2);
        System.out.println(u1);
        System.out.println(u2);
    }

    public static User print() {
        System.out.println("test message");
        return new User();
    }
}
