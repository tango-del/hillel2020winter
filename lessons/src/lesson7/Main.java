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
        String string = "Sobik";

//        System.out.println("---addSymbolToString---");
//        String updateString = addSymbolToString(string, 'l', 2);
//        System.out.println(updateString);
//
//        System.out.println("---extendString(string)---");
//        String school = extendString(updateString, " School");
//        System.out.println(school);
//
//        System.out.println("---extendString(char[])---");
//        String ex1 = " School";
//        String school2 = extendString(updateString, ex1.toCharArray());
//        System.out.println(school2);
//
//        System.out.println("---removeSymbolFromString(index)---");
//        String ex2 = removeSymbolFromString(updateString, 2);
//        System.out.println(ex2);

        System.out.println("---removeSymbolFromString(symbol)---");
        String ex3 = removeSymbolFromString(string, 'b');
        System.out.println(ex3);
    }

    public static int searchIndexOfSymbol(String string, char searchChar) {
        int index = 0;
        for (int i = 0; i < string.length(); i++) {
            if (searchChar == string.charAt(i)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static String removeSymbolFromString(String string, char removeChar) {
        //return symbol index in array
        int index = searchIndexOfSymbol(string, removeChar);
        //поиск наличия символа в строке и запись номера индекса в переменную index

        /*TODO как сделать проверку на отстутсвие если нужно делать инициализацию
           i = 0 то он уберёт первый индекс в строке
         */
//        for (int i = 0; i < string.length(); i++) {
//            if (removeChar == string.charAt(i)) {
//                index = i;
//                break;
//            }
//        }
        //return вызов метода удаления символа с входными пар-ми строки и индекса
        return removeSymbolFromString(string, index);
    }

    public static String removeSymbolFromString(String string, int removeSymbolAtIndex) {
        //создание массива char с длиной string - 1
        char[] newArr = new char[string.length() - 1];
        /*
        один проход по массиву циклом в котором
        до индекса removeSymbolAtIndex идёт копирование элементов у строки с таким же номером индекса
        когда номер итерации >= removeSymbolAtIndex копирует значения строки начиная с индекса + 1
         */
        for (int i = 0; i < newArr.length; i++) {
            if (i >= removeSymbolAtIndex) {
                newArr[i] = string.charAt(i + 1);
            } else {
                newArr[i] = string.charAt(i);
            }
        }
        return new String(newArr);

        /*
        Два цикла по массиву, первый копирует все символы в новый массив до допустимой длинны
        второй цикл начинает итерацию с индекса removeSymbolAtIndex
        копирует значения строки начиная с индекса + 1
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = string.charAt(i);
        }
        for (int i = removeSymbolAtIndex; i < newArr.length; i++) {
            newArr[i] = string.charAt(i + 1);
        }
         */
    }

    //extend char[] - string and return string
    public static String extendString(String string, char[] test) {
        return string + new String(test);
    }

    //extend string - string and return string
    public static String extendString(String str, String string) {
        return str + string;
    }

    public static String addSymbolToString(String string, char symbol, int moveSymbolsAtIndex) {
        //создаю массив char с длиной строки str увеличенной на 1
        char[] arrayStr = new char[string.length() + 1];
        //копирую символы строки str в массив char
        copySymbolsToLargerArray(string, arrayStr);

        /*прохожу по массиву descending с последнего элемента length - 1
        до индекса startMoveSymbolsAt
        i = i - 1
         */
        for (int i = arrayStr.length - 1; i > moveSymbolsAtIndex; i--) {
            arrayStr[i] = arrayStr[i - 1];
        }
        //в заданный индекс присваиваю symbol
        arrayStr[moveSymbolsAtIndex] = symbol;
        return new String(arrayStr);
    }

    private static void copySymbolsToLargerArray(String string, char[] arrayStr) {
        for (int i = 0; i < string.length(); i++) {
            arrayStr[i] = string.charAt(i);
        }
    }
}
