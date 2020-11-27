package lesson7;

public interface StringOperations {
    default int searchIndexOfSymbol(String string, char searchChar) {
        //поиск наличия символа в строке и запись номера индекса в переменную index
        /*TODO как сделать проверку на отстутсвие если нужно делать инициализацию
           i = 0 то он уберёт первый индекс в строке
         */
        int index = 0;
        for (int i = 0; i < string.length(); i++) {
            if (searchChar == string.charAt(i)) {
                index = i;
                System.out.println("Symbol: " + searchChar);
                System.out.println("Index: " + index);
                break;
            }
        }
        return index;
    }
    default String removeSymbolFromString(String string, char removeChar) {
        //return symbol index in array
        int index = searchIndexOfSymbol(string, removeChar);
        //return вызов метода удаления символа с входными пар-ми строки и индекса
        return removeSymbolFromString(string, index);
    }

    default String removeSymbolFromString(String string, int removeSymbolAtIndex) {
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
    default String extendString(String string, char[] test) {
        return string + new String(test);
    }

    //extend string - string and return string
    default String extendString(String str, String string) {
        return str + string;
    }

    default String addSymbolToString(String string, char symbol, int moveSymbolsAtIndex) {
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
