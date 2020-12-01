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
        StringList stringList = new StringList();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        System.out.println(stringList.toString());
        stringList.add("4", 1);
        stringList.add("5", 2);
        System.out.println(stringList.toString());
        stringList.remove(args.length - 1);
        stringList.remove("2");
        System.out.println(stringList.toString());

        System.out.println(stringList.get(1));
        System.out.println(stringList.get("5"));
        System.out.println(stringList.get("6"));
    }
}
