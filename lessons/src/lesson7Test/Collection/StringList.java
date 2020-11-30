package lesson7Test.Collection;

import java.util.Arrays;

public class StringList implements StringCollection {

    public String[] args;

    public StringList() {
        this.args = new String[1];
    }

    @Override
    public void listArgs() {
//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//        }
        for(String arg : args) {
            System.out.println(arg);
        }
    }

    //add String to last index that null
    @Override
    public void addString(String arg) {
        if (checkForEmptyIndex()) {
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    args[i] = arg;
                    break;
                }
            }
        }
    }

    //add String to index and move other elements
    public void addString(String arg, int index) {
        if (!checkForEmptyIndex()) {
            args[index] = arg;
        } else {
            moveElementsInArray(arg, index);
        }
    }

    private void moveElementsInArray(String arg, int index) {
        /*прохожу по массиву descending с последнего элемента length - 1
        до индекса startMoveSymbolsAt
        i = i - 1
         */
        for (int i = args.length - 1; i > index; i--) {
            args[i] = args[i - 1];
        }
        //в заданный индекс присваиваю строку arg
        args[index] = arg;
    }

    private boolean checkForEmptyIndex() {
        int count = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i] != null) {
                count++;
            }
        }
        if (count == args.length) {
            extendStringArray();
        }
        return true;
    }

    private void extendStringArray() {
        int indexValue = args.length / 4;
        //новый массив увеличен на 1
        String[] newArgs = new String[args.length + 1];
        //copy elements to new array
        copyArray(args, newArgs);
        //copy link of new array to args
        args = newArgs;
    }

    private void copyArray(String[] args, String[] newArray) {
        for (int i = 0; i < args.length; i++) {
            newArray[i] = args[i];
        }
    }

    @Override
    public String toString() {
        return "StringList{" +
                "args=" + Arrays.toString(args) +
                '}';
    }
}
