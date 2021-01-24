package lesson7;

import lesson7.Collection.StringList;

/**
 * Реализовать простую коллекцию для String на базе массива.
 *  добавить следующие методы для работы с коллекцией:
 *  добавлять (add), (по индеку или значению)
 *  Добавление без индекса - добавление в конец
 *  добавление по индексу -все элементы что находятся в права от индекса копируем в право
 *  удалять(delete), (по индексу или значению)
 *  доставать по индексу (get)
 *  искать по значению возвращать индекс
 */

public class Main {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        StringList string = new StringList();
        string.add("1");
        string.add("2");
        string.add("3");
        string.add("4");
        string.add("5");
        string.add("6");
        System.out.println(string);
        string.add("7");
        string.add("8");
        string.add("9");
        string.add("10");
        System.out.println(string.toString());
        string.add(10, "11");
        string.add(11, "12");
        string.add("13");
        System.out.println(string.toString());
        string.remove(0);
        string.add("14");
        string.add("15");
        string.add("16");
        string.remove("10");
        System.out.println(string.toString());
        System.out.println(string.get("9"));
        System.out.println(string.get(4));
    }
}
