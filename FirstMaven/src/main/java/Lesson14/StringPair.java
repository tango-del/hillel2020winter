package Lesson14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Имеется коллекция из String, привести все стринги в UPPERCASE
 * и вернуть коллекцию List<Pair>in: "one", "two", ...out: {"one":"ONE"}, {"two", "TWO"}
 */

public class StringPair {

    public List<Pair> transformArray(List<String> list) throws NullPointerException {
        if (list == null) {
            throw new NullPointerException("Array not initialized");
        }
        //check array not empty
        if (!list.isEmpty()) {
            List<Pair> result = list.stream()
                    //on each iteration creates new Pair and sets him first\second String
                    .map(i -> new Pair(i, i.toUpperCase()))
                    .collect(Collectors.toList());
            //return link
            return result;
        } else {
            //return new array
            return new ArrayList<>();
        }
    }
}
