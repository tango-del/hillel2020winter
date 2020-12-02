package lesson8;
/*
TODO Реализовать простую коллекцию для String на базе массива использую интерфейс
 Interface collection:
 -boolean add(Object o); +
 -boolean add(index, Object o); +
 -boolean delete (Object o); +
 -Object get(int index); +
 -boolean contain(Object o); +
 -boolean equals (Collection str),
 -boolean clear(),
 -int size(),
 */

import lesson8.Collection.StringList;

public class Main {
    public static void main(String[] args) {
        StringList<String> string = new StringList<>();
        StringList<String> string2 = new StringList<>();
        string.add("1");
        string.add("2");
        string.add("3");
        string2.add("1");
        string2.add("2");
        string2.add("3");
        string2.add("3");
        System.out.println(string.toString());
        System.out.println(string2.toString());
        System.out.println(string.equals(string2));
        string2.removeElement(3);
        System.out.println(string.equals(string2));

        System.out.println(string2.clear());
        System.out.println(string2.toString());
        System.out.println(string2.size());
    }
}
