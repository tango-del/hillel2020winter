package lesson10;

import lesson10.Collection.StringColl;
import lesson8.Collection.MyOwnIterator;

/*
TODO
 1. Напишите метод, который на вход получает коллекцию объектов, а возвращает коллекцию уже без дубликатов.
 2. Написать итератор по массиву(не коллекции), размер массива заваетя через конструктор (
 3. написать программу для вычисления корней квадратного уравнения
 */
public class Main {
    public static void main(String[] args) {
        StringColl str = new StringColl();
        str.add("one");
        str.add("two");
        str.add("three");
        str.add("one");
        str.add("five");
        str.add("one");
        System.out.println(str);
        StringColl abc = str.removeDuplicates(str);
        System.out.println(abc);


        MyOwnIterator test = new MyOwnIterator(str.getArgs());
        int i = 0;
//        while (test.hasNext()){
//            if (test.next() != null){
//                System.out.println(test.getArray()[i]);
//                ++i;
//            }
//        }
        StringBuilder a = new StringBuilder();
        a.append("[");
        while (test.hasNext()) {
            if (test.next() != null) {
                a.append(test.getArray()[i]).append(", ");
                ++i;
            }
        }
        a.append("]");
        System.out.println(a);
    }
}
