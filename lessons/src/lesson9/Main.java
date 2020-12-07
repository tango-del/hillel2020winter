package lesson9;
/*
TODO на основе интерфейса - реализовать коллекцию на основе связного списка
 - boolean add(String str); +
 - boolean addAll(String[] strArr); +
 - boolean addAll(Collection strColl); +
 - boolean delete (int index); +
 - boolean delete (String str); +
 - String get(int index); +
 - boolean contains(String str);
 - boolean clear();
 - int size(); +
 - boolean trim();
 - boolean compare(Collection coll);
 */

import lesson9.Collection.LinkedString;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedString example = new LinkedString();
        example.add("1");
        example.add("2");
        example.add(null);
        example.add("3");
        example.add("4");
        example.printList();
        System.out.println("delete null");
        example.delete(null);
        example.printList();
        System.out.println("add 5");
        example.add("5");
        example.delete("4");
        example.printList();

        String[] str = new String[3];
        str[0] = "6";
        str[1] = "7";
        str[2] = "8";
        example.addAll(str);
        example.printList();

        LinkedString example1 = new LinkedString();
        example1.add("9");
        example1.add("10");
        example1.add("11");
        example1.printList();

        example.addAll(example1);
        example.printList();
//        LinkedList<String> ex = new LinkedList<>();
//        /*
//        header first -> Two
//        Two -> Three -> Four
//        header last -> four
//         */
//        ex.add("One");
//        ex.add("Two");
//        ex.add("Three");
//        ex.add("Four");
//        System.out.println(ex);
//        System.out.println(ex);
//        LinkedList<String> ex2 = new LinkedList<>();
//        ex2.add("Five");
//        ex2.add("Six");
//        ex2.add("Seven");
//        System.out.println(ex2);
//        ex.addAll(ex2);
//        System.out.println(ex);
    }
}
