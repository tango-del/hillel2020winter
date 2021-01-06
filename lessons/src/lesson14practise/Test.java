package lesson14practise;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        List<String> list = Stream.of("JPoint",
                "HolyJS",
                "Devoxx",
                "Devoxx",
                "HolyJS",
                "JPoint")
                .sequential()
                .filter(set::add)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(list);

        System.out.println("----------");
        List<String> ll = new ArrayList<>();
        ll.add("meat");
        ll.add("bread");
        ll.add("sassage");
        Stream<String> stream = list.stream()
                .filter(a -> a.length() < 5)
                .map(a -> a + "_map");
        ll.add("eggs");
        stream.forEach(System.out::println);
        System.out.println("----------");

        List<String> strings = new LinkedList<>();
        List<String> strings2 = new LinkedList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.add("five");
        System.out.println(strings);

        strings.stream()
                .filter(e -> (e.equals("one")) || e.equals("two"))
                //.map(e -> strings2::add)
                .map(e -> strings2.add(e))
                .forEach(System.out::println);
        System.out.println(strings2);

        Function<String, Integer> toInteger = Test::parse;
        Integer integer = toInteger.apply("5");
    }

    private static Integer parse(String s) {
        return Integer.parseInt(s);
    }


    public static void tes() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Predicate<Integer> tt = (u) -> u < 5;
        Predicate<Integer> tt2 = (u) -> u <= 5;

        List<Integer> list1 = list
                .stream() // [1, 2, 3, 4, 5]
                /*
                 [1, 2, 3, 4] - создаёт новый массив или ставит пометки
                 в исходном массиве которые будет собирать?
                 */
                .filter(e -> e < 5)  // [1, 2, 3, 4]
                .map(e -> e = e + 1)
                .filter(e -> e < 5)
                .collect(Collectors.toList()); // [2, 3, 4]


        System.out.println(list);
        System.out.println(list1);
    }
}
