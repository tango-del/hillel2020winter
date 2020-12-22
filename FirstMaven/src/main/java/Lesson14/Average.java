package Lesson14;

/*
 TODO
  Имеется коллекция из Integers, использую стримы посчитать среденее значения всех чисел
 */

import java.util.ArrayList;
import java.util.List;

public class Average {

    public double findAverage(List<Integer> list) throws NullPointerException {
        if (list == null) {
            throw new NullPointerException("Array not initialized");
        }
        double result = 0;

        if (!list.isEmpty()) {
            // writes value in result
            result = list.stream()
                    .mapToDouble(u -> u)
                    // summarize all elements in array and then divide by array length
                    .sum() / list.size();
            //System.out.println(result);
            return result;
        } else {
            //System.out.println("Array is empty");
            return result;
        }
    }

    //check that array not empty, if false then calculate average number of array
    public double findAverage2(List<Integer> list) throws NullPointerException {
        if (list == null) {
            throw new NullPointerException("Array not initialized");
        }
        double result = 0;
        //check array not empty
        if (!list.isEmpty()) {
            result = list.stream()
                    //take value of each element in array
                    .mapToInt(Integer::valueOf) // .mapToInt(u -> u)
                    //calculate average number
                    .average()
                    .getAsDouble();
                    //if object not null then print average value
                    //.ifPresent(System.out::println);
            //System.out.println(result);
            return result;
        } else {
            //System.out.println("Array is empty");
            return result;
        }
    }
}
