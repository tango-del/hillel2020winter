package Lesson14;

import java.util.List;

/**
 * Имеется коллекция из Integers, использую стримы посчитать среденее значения всех чисел
 * Throwable Exception I\O Exception -> DataFind
 */

public class Average {

    public double findAverage(List<Integer> list) throws NullPointerException {
        if (list == null) {
            throw new NullPointerException("Array not initialized");
        }
        double result = 0;

        if (!list.isEmpty()) {
            // writes value in result
            result = list.stream()
                    .mapToDouble(u -> u)//map peek
                    // summarize all elements in array and then divide by array length
                    .sum() / list.size();//min max count collect
            //System.out.println(result);
            return result;
        } else {
            //System.out.println("Array is empty");
            return result;
        }
    }

    //check that array not empty, if false then calculate average number of array
    public double findAverage2(List<Integer> list) throws NullPointerException {
        //List<Integer> list;
        if (list == null) {
            throw new NullPointerException("Array not initialized");
        }
        double result = 0;
        //check array not empty
        //List<Integer> list = new ArrayList<>();
        if (!list.isEmpty()) {
            result = list.stream()
                    // 1, 2, 3, 4
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
