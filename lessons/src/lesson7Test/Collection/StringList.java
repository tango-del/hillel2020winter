package lesson7Test.Collection;

import java.util.Arrays;

public class StringList implements StringCollection {

    private int count;

    public String[] args;

    public StringList() {
        this.args = new String[10];
    }

    @Override
    public String get(String str) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] == str) {
                return String.valueOf(i);
            }
        }
        return "No matches";
    }

    @Override
    public String get(int index) {
        if (index < args.length) {
            return args[index];
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
    public void add(String str) {
        checkFreeIndex();

        args[count] = str;
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
            count = i;
        }
    }

    @Override
    public void add(String str, int index) {
        if (index < 0) {
            System.out.println("Incorrect index value");
        } else if (args[index - 1] != null) {
            extendStringArray();
        }
        moveElementsInArray(str, index);
        args[index] = str;
    }

//    @Override
//    public void add(String str, int index) {
//        if (index < 0) {
//            System.out.println("Incorrect index value");
//        } else if(index == args.length) {
//            extendStringArray();
//        }
//        else if (args[index] != null) {
//            //extendStringArray();
//            moveElementsInArray(str, index);
//            //args[index] = str;
//        } else if (args[index] == null) {
//            args[index] = str;
//        }
//        args[index] = str;
//        extendStringArray();
//    }

    private boolean isAbleMoveSymbols(int index) {
        if (args.length + 1 <= args.length) {
            return true;
        }
        return false;
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
        до index
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
