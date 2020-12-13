package lesson10.Collection;

import java.util.Arrays;

public class StringColl implements Collection {
    private int count;
    private Object[] args;


    public StringColl() {
        this.args = new Object[10];
    }

    @Override
    public boolean add(Object str) {
        if (count >= args.length) {
            extendArray();
        }
        args[count++] = str;
        return true;
    }

    public StringColl removeDuplicates(StringColl array) {
        StringColl temp = new StringColl();
        for (int i = 0; i < array.size(); i++) {
            if (!array.contains(temp ,args[i])) {
                temp.add(array.args[i]);
            }
        }
        return temp;
    }

    @Override
    public int size() {
        return count;
    }

    public Object[] getArgs() {
        return args;
    }

    @Override
    public boolean contains(StringColl temp ,Object str) {
        boolean result = false;
        for (int i = 0; i < temp.size(); i++) {
            if (temp.args[i] == str) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(args);
    }

    private void extendArray() {
        //copy elements from old array to new array with new size and copy his link to old array
        //length = 10  - >  16
        int size = (args.length * 3 / 2) + 1;
        Object[] newArray = new Object[size];
        args = copyArray(newArray);
    }

    private Object[] copyArray(Object[] newArray) {
        for (int i = 0; i < args.length; i++) {
            newArray[i] = args[i];
        }
        return newArray;
    }
}
