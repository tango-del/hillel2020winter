package lesson9;
/*
TODO на основе интерфейса - реализовать коллекцию на основе связного списка
 - boolean add(String str);
 - boolean addAll(String[] strArr);
 - boolean addAll(Collection strColl);
 - boolean delete (int index);
 - boolean delete (String str);
 - String get(int index);
 - boolean contains(String str);
 - boolean clear();
 - int size();
 - boolean trim();
 - boolean compare(Collection coll);
 */

import lesson9.Collection.StringLinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        LinkedList<String> str = new LinkedList<>();
        str.add("1");
        str.add("2");
        str.add("3");
        str.add("4");
        str.add(1,"1.1");
    }
}
