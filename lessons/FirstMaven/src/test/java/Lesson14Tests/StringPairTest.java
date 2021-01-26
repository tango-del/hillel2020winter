package Lesson14Tests;

import Lesson14.Pair;
import Lesson14.StringPair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StringPairTest {
    static StringPair stringPair;
    static List<String> arr1;
    static List<String> arr2;
    static List<String> arr3; // null

    @BeforeAll
    static void initArray() {
        stringPair = new StringPair();
        arr1 = new ArrayList<>();
        arr1.add("Mark");
        arr1.add("Octavius");
        arr1.add("Spider");
        arr1.add("Halk");
        arr1.add("Rufallo");

        arr2 = new ArrayList<>();
    }

    @Test
    public void checkTransformArray() {
        System.out.println("---test: checkTransformArray---");
        //check exception throw
        Assertions.assertThrows(NullPointerException.class,
                () -> stringPair.transformArray(arr3));

        List<Pair> result = stringPair.transformArray(arr1);

        List<Pair> test2 = new ArrayList<>();
        test2.add(new Pair("Mark", "MArK"));
        test2.add(new Pair("Octavius", "OCTaVIUS"));
        test2.add(new Pair("Spider", "SPI1DER"));
        test2.add(new Pair("Halk", "HaLK"));
        test2.add(new Pair("Rufallo", "RUFALLO"));
        Assertions.assertNotEquals(result, test2);

        List<Pair> test = new ArrayList<>();
        test.add(new Pair("Mark", "MARK"));
        test.add(new Pair("Octavius", "OCTAVIUS"));
        test.add(new Pair("Spider", "SPIDER"));
        test.add(new Pair("Halk", "HALK"));
        test.add(new Pair("Rufallo", "RUFALLO"));

        //check two arrays equals
        Assertions.assertEquals(result, test);


        List<Pair> testNotNull = stringPair.transformArray(arr2);
        //check if send empty array method will not return null, instead return new array
        Assertions.assertNotNull(testNotNull);
    }
}
