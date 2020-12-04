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
        StringList string = new StringList();
        string.add("1");
        string.add("2");
        string.add("3");
        string.add("4");
        string.add("5");
        string.add("6");
        System.out.println(string.add("7"));
        string.add("8");
        string.add("9");
        string.add("10");
        System.out.println(string.toString());
        System.out.println(string.add("11", 10));
        string.add("12", 11);
        string.add("13");
        System.out.println(string.toString());
        string.remove(0);
        System.out.println(string.remove(10));
        System.out.println(string.remove("13"));
        string.add("14");
        string.add("15");
        string.add("16");
        string.remove("10");
        string.add("17");
        System.out.println(string.toString());
        System.out.println(string.get(0));
        System.out.println(string.get("0"));
        System.out.println(string.size());
        System.out.println(string.contains("3"));
        System.out.println(string.contains("0"));


        System.out.println(string.clear());
        System.out.println(string.toString());
    }
}
