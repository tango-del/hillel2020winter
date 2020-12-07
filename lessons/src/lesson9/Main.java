package lesson9;
/*
TODO на основе интерфейса - реализовать коллекцию на основе связного списка
 - boolean add(String str); +
 - boolean addAll(String[] strArr);
 - boolean addAll(Collection strColl);
 - boolean delete (int index); +
 - boolean delete (String str);
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
//        example.add("One");
//        example.add("Two");
//        example.add("Three");
//        example.add("Four");
//        example.add("Five");
//        example.printList();
//        System.out.println("delete Four");
//        example.delete(4);
//        example.printList();
//        System.out.println("add Six");
//        example.add("Six");
//        example.printList();
//        System.out.println("delete Two");
//        example.delete(1);
//        example.printList();


        LinkedList<String> ex = new LinkedList<>();
        /*
        header first -> Two
        Two -> Three -> Four
        header last -> four
         */
        ex.add("One");
        ex.add("Two");
        ex.add("Three");
        ex.add("Four");
        System.out.println(ex);
        System.out.println(ex);

//        LinkedList<String> ex2 = new LinkedList<>();
//        ex2.add("Five");
//        ex2.add("Six");
//        ex2.add("Seven");
//        System.out.println(ex2);
//        ex.addAll(ex2);
//        System.out.println(ex);
    }
}
