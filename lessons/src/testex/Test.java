package testex;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        List<Integer> abc = new ArrayList<>();
        abc.add(12);
        abc.add(51);
        abc.add(64);
        abc.add(96);
        abc.add(3);
        System.out.println(abc);
        System.out.println(abc.contains(51));

        Set<Integer> test = new HashSet<>(abc);
        System.out.println(test);

    }
}
