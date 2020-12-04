package lesson8.Collection;

import java.util.Arrays;
import java.util.Objects;

public class StringList implements StringCollection {
    public int count;

    public Object[] args;

    public StringList() {
        this.args = new String[10];
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
    public boolean remove(Object str) {
        remove(str, args);
        return true;
    }

    private void remove(Object str, Object[] args) {
        int index = 0;
        for (int i = 0; i < this.args.length; i++) {
            if (this.args[i] == str) {
                index = i;
                break;
            }
        }
        this.args = decreaseArray(index);
        count--;
    }

    @Override
    public boolean remove(int index) {
        remove(index, args);
        return true;
    }

    private void remove(int index, Object[] args) {
        this.args = decreaseArray(index);
        count--;
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

    @Override
    public boolean add(Object str) {
        add(str, args);
        return true;
    }

    private void add(Object str, Object[] args) {
        //check if need extend array
        if (count >= this.args.length) {
            extendArray();
        }
        this.args[count++] = str;
        System.out.println("count: " + count);
    }

    @Override
    public boolean add(Object str, int index) {
        add(str, args, index);
        return true;
    }

    private void add(Object str, Object[] args, int index) {
        //check if index negative
        if (index < 0) {
            System.out.println("Incorrect index value");
        } else if (count >= this.args.length || count + 1 >= this.args.length) {
            //check if need extend array
            extendArray();
        }
        if (this.args[index] == null && index <= count) {
            this.args[index] = str;
            if (this.args[index + 1] == null) {
                count++;
            }
        } else if (this.args[index] != null && index <= count) {
            moveElementsOfArray(index);
            this.args[index] = str;
            count++;
        }
        System.out.println("count: " + count);
    }

    private void extendArray() {
        //copy elements from old array to new array with new size and copy his link to old array
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
}