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
 Lesson 10 tasks:
  1. Напишите метод, который на вход получает коллекцию объектов, а возвращает коллекцию уже без дубликатов.
  2. Написать итератор по массиву(не коллекции), размер массива заваетя через конструктор (
  3. написать программу для вычисления корней квадратного уравнения
 */

import Collection.StringList;
import Collection.MyOwnIterator;

public class Main {
    public static void main(String[] args) {

        //StringList
        workWithStringList();

        //HomeWork lesson 10
        //Iterator with remove duplicates
        //workWithIterator();

        //корень квадратного уравнения
        //squareRoot();
    }
    public static void workWithStringList() {
        StringList string = new StringList();
        string.add("1");
        string.add("2");
        string.add("3");
        string.add("4");
        string.add("5");
        string.add("6");
        System.out.println(string);
//        System.out.println(string.remove(8));
//        System.out.println(string.add("9", 8));
//        System.out.println(string.contains("1123"));
//        System.out.println(string.contains("2"));
//        System.out.println(string);
//        System.out.println(string.get("3"));
//        System.out.println(string.remove("13"));
//        System.out.println(string.remove("3"));
//        System.out.println(string);
//        System.out.println(string.add("7"));
//        string.add("8");
//        string.add("9");
//        string.add("10");
//        System.out.println(string.toString());
//        System.out.println(string.add("11", 10));
//        string.add("12", 11);
//        string.add("13");
//        System.out.println(string.toString());
//        string.remove(0);
//        System.out.println(string.remove(10));
//        System.out.println(string.remove("13"));
//        string.add("14");
//        string.add("15");
//        string.add("16");
//        string.remove("10");
//        string.add("17");
//        System.out.println(string.toString());
//        System.out.println(string.get(0));
//        System.out.println(string.get("0"));
//        System.out.println(string.size());
//        System.out.println(string.contains("3"));
//        System.out.println(string.contains("0"));
//
//
//        System.out.println(string.clear());
//        System.out.println(string.toString());
    }

    public static void workWithIterator() {
        StringList string = new StringList();
        string.add("1");
        string.add("1");
        string.add("2");
        string.add("3");
        string.add("4");
        string.add("4");
        string.add("1");
        string.add("5");
        string.add("5");
        string.add("6");
        System.out.println(string);

        StringList abc = string.removeDuplicates(string);
        System.out.println(abc);

        MyOwnIterator str = new MyOwnIterator(abc.getArgs());
        System.out.println(str);
        do {
            if (str.next() == "5") {
                str.remove();
                break;
            }
        } while (str.hasNext());
        System.out.println(str);
    }

    public static void squareRoot() {
        /*
        дискриминант D = b * b - 4 * a * c
         */
        double a = 4;
        double b = -20;
        double c = 25;
        double d = b * b - 4 * a * c;
        if (d > 0) {
            double x1 = (-b - Math.sqrt(d)) / (2 * a);
            double x2 = (-b + Math.sqrt(d)) / (2 * a);
            System.out.println("Два корня");
            System.out.println(x1);
            System.out.println(x2);
        } else if (d == 0) {
            double x = -b / (2 * a);
            System.out.println("Один корень");
            System.out.println(x);
        } else {
            System.out.println("Нету корней");
        }
    }
}