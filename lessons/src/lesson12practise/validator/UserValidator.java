package lesson12practise.validator;

import lesson12practise.AgeException;
import lesson12practise.EmailException;

public class UserValidator {
    void validate (User user) {
        if (!user.getEmail().contains("@")) {
            throw new EmailException("email not valid...");
        }

        if (user.getAge() < 18) {
            throw new AgeException(user.getAge().toString());
        }

        if (user.getCountry().toLowerCase().equals("ukraine")) {
            throw new RuntimeException("incorrect country");
        }
    }
}
