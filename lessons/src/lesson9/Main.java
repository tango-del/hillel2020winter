package lesson9;

import lesson9.Collection.LinkedString;

/**
 на основе интерфейса - реализовать коллекцию на основе связного списка
 - boolean add(String str); +
 - boolean addAll(String[] strArr); +
 - boolean addAll(Lesson12.Collection strColl); +
 - boolean delete (int index); +
 - boolean delete (String str); +
 - String get(int index); +
 - boolean contains(String str); +
 - boolean clear(); +
 - int size(); +
 - boolean trim(); +
 - boolean compare(Lesson12.Collection coll);
 */

public class Main {
    public static void main(String[] args) {
        //create linkedList
        LinkedString example = new LinkedString();
        example.add("1");
        example.add("2");
        example.add("3");
        example.add("4");
        example.add("5");
        example.printList();
        LinkedString example4 = new LinkedString();
        example4.add("1");
        example4.add("2");
        example4.add("3");
        example4.add("4");;
        example4.add("5");;
        example4.printList();
        System.out.println(example.compare(example4));

        System.out.println("delete null");
        System.out.println(example.delete(null));
        example.printList();

        System.out.println("add 5");
        example.add("5");
        System.out.println(example.delete("4"));
        example.printList();

        //create array and extends with example
        String[] str = new String[3];
        str[0] = "6";
        str[1] = "7";
        str[2] = "8";
        example.addAll(str);
        example.printList();

        //create new linkedList
        LinkedString example1 = new LinkedString();
        example1.add("9");
        example1.add(" 10 ");
        example1.add(" 11 ");
        example1.printList();
        //delete all spaces in each value
        example1.trim();
        //extends with list example
        example.addAll(example1);
        example.printList();

        //check if such string contains in list
        System.out.println(example.contains("5"));
        System.out.println(example.contains("spasite_pomogite"));

        //clear all links in list example
        example.printList();
        example.clear();
        example.printList();
    }
}
