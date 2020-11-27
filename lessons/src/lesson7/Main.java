package lesson7;
/*
TODO Реализовать простую коллекцию для String на базе массива.
 добавить следующие методы для работы с коллекцией:
 добавлять (add), (по индеку или значению)
 удалять(delete), (по индексу или значению)
 доставать по индексу (get)
*/

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "Sobik";

        //создаю массив char с длиной строки str увеличенно на 1
        char[] test = new char[str.length() + 1];
        //копирую символы строки str в массив char
        copySymbols(str, test);
        //вывод
        System.out.println(Arrays.toString(test));

        addSymbolToString(test, 'l',  2);

        System.out.println(Arrays.toString(test));

        removeSymbolFromString(test, 2);



        //массив char переделываю в строку

        //String newff = Arrays.toString(test);

        //вывод строки
        //System.out.println(newff);

    }

    public static void removeSymbolFromString(char[] arrChar, int removeSymbolAtIndex) {
        char[] newArr = new char[arrChar.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i >= removeSymbolAtIndex) {
                newArr[i] = arrChar[i + 1];
            } else {
                newArr[i] = arrChar[i];
            }
        }
        System.out.println(Arrays.toString(newArr));
        /*
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arrChar[i];
        }
        System.out.println("newArr");
        System.out.println(Arrays.toString(newArr));

        for (int i = removeSymbolAtIndex; i < newArr.length; i++) {
            newArr[i] = arrChar[i + 1];
        }
        System.out.println(Arrays.toString(newArr));
         */

    }

    public static void addSymbolToString(char[] arrChar, char symbol, int moveSymbolsAtIndex) {
        /*прохожу по массиву копируя значения с конца начиная с последнего элемента length - 1
        до индекса startMoveSymbolsAt
        i - 1 = i
         */
        for (int i = arrChar.length - 1; i > moveSymbolsAtIndex; i--) {
            arrChar[i] = arrChar[i - 1];
        }
        //в заданный индекс присваиваю символ add
        arrChar[moveSymbolsAtIndex] = symbol;
    }

    public static void copySymbols(String str, char[] arrstr) {
        for (int i = 0; i < str.length(); i++) {
            arrstr[i] = str.charAt(i);
        }
    }
}
