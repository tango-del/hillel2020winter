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

        stringList.addString("First");
        stringList.addString("Second");
        stringList.addString("Third");
        stringList.addString("Four");

        System.out.println(stringList.toString());

    }
}
