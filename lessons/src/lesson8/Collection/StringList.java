package lesson8.Collection;

import java.util.Arrays;
import java.util.Objects;

public class StringList implements StringCollection {
    private int count;

    private Object[] args;

    public StringList() {
        this.args = new String[10];
    }

    public Object[] getArgs() {
        return args;
    }

    @Override
    public boolean contains(Object str) {
        boolean result = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i] == str) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean contains(StringList temp, Object str) {
        boolean result = false;
        for (int i = 0; i < temp.size(); i++) {
            if (temp.getArgs()[i] == str) {
                result = true;
                break;
            }
        }
        return result;
    }

    public StringList removeDuplicates(StringList array)
    {
        StringList temp = new StringList();
        for (int i = 0; i < array.size(); i++) {
            if (!array.contains(temp ,args[i])) {
                temp.add(array.getArgs()[i]);
            }
        }
        return temp;
    }

    @Override
    public boolean remove(Object str) {
        int index = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i] == str) {
                index = i;
                break;
            }
        }
        args = decreaseArray(index);
        count--;
        return true;
    }

    @Override
    public boolean remove(int index) {
        args = decreaseArray(index);
        count--;
        return true;
    }

    @Override
    public boolean add(Object str) {
        //check if need extend array
        if (count >= args.length) {
            extendArray();
        }
        args[count++] = str;
        return true;
    }

    @Override
    public boolean add(Object str, int index) {
        //check if index negative
        if (index < 0) {
            System.out.println("Incorrect index value");
        } else if (count >= args.length || count + 1 >= args.length) {
            //check if need extend array
            extendArray();
        }
        if (args[index] == null && index <= count) {
            args[index] = str;
            if (args[index + 1] == null) {
                count++;
            }
        } else if (args[index] != null && index <= count) {
            moveElementsOfArray(index);
            args[index] = str;
            count++;
        }
        return true;
    }

    @Override
    public Object get(Object str) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] == str) {
                return String.valueOf(i);
            }
        }
        return "No matches";
    }

    @Override
    public Object get(int index) {
        if (index < args.length) {
            return args[index];
        }
        return "Index out of exception";
    }

    @Override
    public int size() {
        return args.length;
    }

    @Override
    public boolean clear() {
        this.args = new String[10];
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringList that = (StringList) o;
        return count == that.count && Arrays.equals(args, that.args);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(count);
        result = 31 * result + Arrays.hashCode(args);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(args);
    }

    private Object[] decreaseArray(int index) {
        Object[] newArray = new Object[args.length - 1];
        copyToDecreasedArray(newArray, index);
        return newArray;
    }

    private void copyToDecreasedArray(Object[] newArray, int index) {
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = args[i];
            } else if (i >= index) {
                newArray[i] = args[i + 1];
            }
        }
    }

    private void extendArray() {
        //copy elements from old array to new array with new size and copy his link to old array
        //length = 10  - >  16
        int size = (args.length * 3 / 2) + 1;
        Object[] newArray = new Object[size];
        args = copyArray(newArray);
    }

    //copy all elements from old array to new array
    private Object[] copyArray(Object[] newArray) {
        for (int i = 0; i < args.length; i++) {
            newArray[i] = args[i];
        }
        return newArray;
    }

    //move elements start from args[index] till count + 1
    private void moveElementsOfArray(int index) {
        for (int i = count + 1; i > index ; i--) {
            args[i] = args[i - 1];
        }
    }
}