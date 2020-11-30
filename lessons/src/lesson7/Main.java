package lesson7;
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

public class Main {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        String string = "Hilllel";
        StringMagic example = new StringMagic();

        System.out.println("---addSymbolToString---");
        String updateString = example.addSymbolToString(string, 'l', 2);
        System.out.println(updateString);

        System.out.println("---extendString(string)---");
        String school = example.extendString(updateString, " School");
        System.out.println(school);

        System.out.println("---extendString(char[])---");
        String ex1 = " School";
        String school2 = example.extendString(updateString, ex1.toCharArray());
        System.out.println(school2);

        System.out.println("---removeSymbolFromString(index)---");
        String ex2 = example.removeSymbolFromString(updateString, 2);
        System.out.println(ex2);

        System.out.println("---removeSymbolFromString(symbol)---");
        String ex3 = example.removeSymbolFromString(string, 'l');
        System.out.println(ex3);

        System.out.println("---searchIndexOfSymbol---");
        System.out.println(example.searchIndexOfSymbol(string, 'l'));
    }
}

class StringMagic implements StringOperations {

}