package lesson8.Collection;

import java.util.Arrays;

public class StringList<E> implements StringCollection<E> {

    private int count;

    public String[] args;

    public StringList() {
        this.args = new String[0];
    }

    @Override
    public String get(String str) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] == str) {
                return "index: " + i;
            }
        }
        return "No matches";
    }

    @Override
    public String get(int index) {
        if (index < args.length) {
            return "String: " + args[index];
        }
        return "Index out of exception";
    }

    @Override
    public void remove(String str) {
        int index = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i] == str) {
                index = i;
                break;
            }
        }
        args = decreaseArray(index);
    }

    @Override
    public void remove(int index) {
        args = decreaseArray(index);
    }

    private String[] decreaseArray(int index) {
        String[] newArray = new String[args.length - 1];
        copyToDecreasedArray(newArray, index);
        return newArray;
    }

    private void copyToDecreasedArray(String[] newArray, int index) {
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = args[i];
            } else if (i >= index) {
                newArray[i] = args[i + 1];
            }
        }
    }

    @Override
    public boolean add(E str) {
        this.add(str);
        return true;
    }

    private void add(E str, int index) {
        checkFreeIndex();
        //args[count] = str;
    }

    private void checkFreeIndex() {
        int i;
        for (i = 0; i < args.length; i++) {
            if (args[i] == null) {
                count = i;
                break;
            }
        }
        if (i == args.length) {
            extendStringArray();
            count = args.length - 1;
        }
    }

    public void add(String str, int index) {
        if (args[index - 1] != null) {
            extendStringArray();
        }
        moveElementsInArray(str, index);
        args[index] = str;
    }

    private void extendStringArray() {
        //новый массив увеличен на 1
        String[] newArgs = new String[args.length + 1];
        //copy elements to new array
        copyToExtendArray(args, newArgs);
        //copy link of new array to args
        args = newArgs;
    }

    //copy all elements from old array to new array
    private void copyToExtendArray(String[] args, String[] newArray) {
        for (int i = 0; i < args.length; i++) {
            newArray[i] = args[i];
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

    @Override
    public String toString() {
        return Arrays.toString(args);
    }
}
