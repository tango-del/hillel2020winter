package lesson7Test.Collection;

import java.util.Arrays;

public class StringList implements StringCollection {

    public String[] args;

    public StringList() {
        this.args = new String[3];
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
        if (checkForEmptyIndexInArray()) {
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    args[i] = arg;
                    break;
                }
            }
        } else {
            extendStringArray();
        }
    }

    private boolean checkForEmptyIndexInArray() {
        int count = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                count++;
                break;
            }
        }
        if (count > 0) {
            return true;
        } else {
            return false;
        }
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
