package Lesson14;

import java.util.List;
import java.util.function.Predicate;

public class OutputStringsLowCase {

    public static void printStringLowCase(List<String> strings) throws NullPointerException {
        if (strings == null) {
            throw new NullPointerException("Array not initialized");
        }
        if (!strings.isEmpty()) {
            Predicate<String> isLowCase = u -> checkLoweCase(u);
            Predicate<String> isLengthEqualFour = u -> u.length() == 4;
            strings.stream()
                    .filter(isLowCase.and(isLengthEqualFour))
                    .forEach(e -> System.out.print(e + " "));
                    //.forEach(System.out::println);
        }
    }

    public static boolean checkLoweCase(String str) throws NullPointerException {
        if (str == null) {
            throw new NullPointerException("String is null");
        }
        // arR -> arr
        return str.equals(str.toLowerCase());
    }
}
