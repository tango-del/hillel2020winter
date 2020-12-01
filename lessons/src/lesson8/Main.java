package lesson8;
/*
TODO Реализовать простую коллекцию для String на базе массива использую интерфейс
 -Interface collection:
 -boolean add(Object o);
 -boolean add(index, Object o);
 -boolean delete (Object o);
 -Object get(int index);
 -boolean contain(Object o);
 -boolean equals (Collection str),
 -boolean clear(),
 -int size(),
 */

import lesson8.Collection.StringList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        str.add("1");
        System.out.println(str.toString());
        System.out.println(str.add("1"));
        System.out.println(str.toString());

        StringList<String> string = new StringList<>();
    }
}
