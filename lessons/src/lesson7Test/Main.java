package lesson7Test;
/*
TODO Реализовать простую коллекцию для String на базе массива.
 добавить следующие методы для работы с коллекцией:
 добавлять (add), (по индеку или значению)
 Добавление без индекса - добавление в конец
 добавление по индексу -все элементы что находятся в права от индекса копируем в право
 удалять(delete), (по индексу или значению)
 доставать по индексу (get)
 искать по значению возвращать индекс
*/

import lesson7Test.Collection.StringList;

public class Main {
    public static void main(String[] args) {
        init();
    }
    public static void init() {
        StringList stringList = new StringList();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.add("2.1", 2);
        stringList.add("5.1", 6);
        stringList.add("6");
        stringList.add("7", 8);
        stringList.add("8");
        System.out.println(stringList.toString());
        stringList.add("8.1", 10);
        System.out.println(stringList.toString());
        System.out.println("remove string 5.1");
        stringList.remove("5.1");
        System.out.println(stringList.toString());
        System.out.println("remove string at index 2");
        stringList.remove(2);
        System.out.println(stringList.toString());

        System.out.println("get string at index 1");
        System.out.println(stringList.get(1));
        System.out.println("get index of string 4 and 6");
        System.out.println(stringList.get("4"));
        System.out.println(stringList.get("6"));
    }
}
