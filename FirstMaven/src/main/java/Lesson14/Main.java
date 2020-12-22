package Lesson14;
/*
 TODO
  1 - Имеется коллекция из Integers, использую стримы посчитать среденее значения всех чисел
  2 - Имеется коллекция из String, привести все стринги в UPPERCASE
  и вернуть коллекцию List<Pair>in: "one", "two", ...out: {"one":"ONE"}, {"two", "TWO"}, ...
  3 - Имеется коллекция из String, отфильтровать и вывести на экран все значения, которые написаны в loverCase and length = 4
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //average();
        //strPair();
        //checkStringsForLowCase();
    }

    public static void checkStringsForLowCase() {
        List<String> strings = new ArrayList<>();
        strings.add("Mark");
        strings.add("sped");
        strings.add("Octavius");
        strings.add("ODWw");
        strings.add("hsee");
        strings.add("spEd");
        strings.add("FHGI");
        strings.add("halk");
        strings.add("rufallo");
        System.out.println(strings);
        OutputStringsLowCase.printStringLowCase(strings);

    }

    public static void strPair() {
        StringPair str = new StringPair();
        List<String> strings = new ArrayList<>();
        strings.add("Mark");
        strings.add("Octavius");
        strings.add("Spider");
        strings.add("Halk");
        strings.add("Rufallo");
        System.out.println(strings);

        List<Pair> fin = str.transformArray(strings);
        System.out.println(fin);
    }

    public static void average() {
        Average average = new Average();
        List<Integer> iList = new ArrayList<>();
        iList.add(82);
        iList.add(60);
        iList.add(23);
        iList.add(88);
        iList.add(24);

        List<Integer> iList2 = new ArrayList<>();

        List<Integer> iList3 = null;

        System.out.println(average.findAverage(iList));
        System.out.println(average.findAverage(iList2));
        //System.out.println(average.findAverage(iList3));
        average.findAverage2(iList);
        average.findAverage2(iList2);
        //average.findAverage2(iList3);
    }
}