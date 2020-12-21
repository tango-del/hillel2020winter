package lesson7.Collection;

import java.util.Arrays;

public class StringList implements StringCollection{
    private int count;

    private String[] args;

    public StringList() {
        this.args = new String[10];
    }

    @Override
    public void add(String str) {
        //check if need extend array
        if (count >= args.length) {
            extendArray();
        }
        args[count++] = str;
    }

    @Override
    public void add(int index, String str) {
        //check if index negative
        if (index < 0 || index > count) {
            System.out.println("Incorrect index value");
        } else if (count >= args.length || count + 1 >= args.length) {
            //check if need extend array
            extendArray();
        }
        if (args[index] == null && index <= count) {
            args[index] = str;
            if (args[index + 1] == null){
                //if next element != null count don`t need ++
                count++;
            }
        } else if (args[index] != null && index <= count) {
            moveElementsOfArray(index);
            args[index] = str;
            count++;
        }
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
        count--;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > count) {
            System.out.println("Incorrect index value");
        } else {
            args = decreaseArray(index);
            count--;
        }
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
    public String toString() {
        return Arrays.toString(args);
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

    private void moveElementsOfArray(int index) {
        //move elements start from args[index] till count + 1
        for (int i = count + 1; i > index ; i--) {
            args[i] = args[i - 1];
        }
    }

    private void extendArray() {
        //copy elements from old array to new array with new size and copy his link to old array
        int size = (args.length * 3 / 2) + 1;
        String[] newArray = new String[size];
        args = copyArray(newArray);
    }

    private String[] copyArray(String[] newArray) {
        for (int i = 0; i < args.length; i++) {
            newArray[i] = args[i];
        }
        return newArray;
    }
}
