package Lesson14Tests;

import Lesson14.Average;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AverageTest {

    static Average average;
    static List<Integer> iList;
    static List<Integer> iList2;
    static List<Integer> iList3; //null

    @BeforeAll
    static void initArray() {
        average = new Average();
        iList = new ArrayList<>();
        iList.add(82);
        iList.add(60);
        iList.add(23);
        iList.add(88);
        iList.add(24);

        iList2 = new ArrayList<>();
    }

    @Test
    public void checkFindAverage() {
        System.out.println("---test: checkFindAverage---");
        //check exception throw
        Assertions.assertThrows(NullPointerException.class, () -> average.findAverage(iList3));
        //check that average number of empty array: 0
        Assertions.assertEquals(0, average.findAverage(iList2));
        //check average number of array is not zero
        Assertions.assertNotEquals(0, average.findAverage(iList));
        //check average number is not 13 {82, 60, 23, 88, 24}
        Assertions.assertNotEquals(13, average.findAverage(iList));
        //check average number is 55.4 {82, 60, 23, 88, 24}
        Assertions.assertEquals(55.4, average.findAverage(iList));
    }

    @Test
    public void checkFindAverage2() {
        System.out.println("---test: checkFindAverage2---");
        Assertions.assertThrows(NullPointerException.class, () -> average.findAverage2(iList3));
        //check that average number of empty array: 0
        Assertions.assertEquals(0, average.findAverage2(iList2));
        //check average number of array is not zero
        Assertions.assertNotEquals(0, average.findAverage2(iList));
        //check average number is not 13 {82, 60, 23, 88, 24}
        Assertions.assertNotEquals(13, average.findAverage2(iList));
        //check average number is 55.4 {82, 60, 23, 88, 24}
        Assertions.assertEquals(55.4, average.findAverage2(iList));
    }
}
