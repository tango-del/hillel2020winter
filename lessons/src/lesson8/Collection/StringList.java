package lesson8.Collection;

import java.util.Arrays;
import java.util.Objects;

public class StringList<E> implements StringCollection<E>{
    private int count;

    public Object[] args;

    public StringList() {
        this.args = new String[0];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringList<?> that = (StringList<?>) o;
        return count == that.count &&
                Arrays.equals(args, that.args);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(count);
        result = 31 * result + Arrays.hashCode(args);
        return result;
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
            return (String) args[index];
        }
        return "Index out of exception";
    }

    @Override
    public boolean remove(Object str) {
        removeElement(str);
        return true;
    }

    public void removeElement(Object str) {
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
    public boolean remove(int index) {
        removeElement(index);
        return true;
    }

    public void removeElement(int index) {
        args = decreaseArray(index);
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
        adD(str);
        return true;
    }

    @Override
    public void adD(Object str) {
        checkFreeIndex();
        args[count] = (String) str;
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
    public boolean add(Object str, int index) {
        adD(str, index);
        return true;
    }

    @Override
    public void adD(Object str, int index) {
        if (index < 0) {
            System.out.println("Incorrect index value");
        } else if (args[index - 1] != null) {
            extendStringArray();
        }
        moveElementsInArray(str, index);
        args[index] = str;
    }

    private boolean isAbleMoveSymbols(int index) {
        if (args.length + 1 <= args.length) {
            return true;
        }
        return false;
    }

    private void extendStringArray() {
        //новый массив увеличен на 1
        Object[] newArgs = new Object[args.length + 1];
        //copy elements to new array
        copyToExtendArray(args, newArgs);
        //copy link of new array to args
        args = newArgs;
    }

    //copy all elements from old array to new array
    private void copyToExtendArray(Object[] args, Object[] newArray) {
        for (int i = 0; i < args.length; i++) {
            newArray[i] = args[i];
        }
    }

    private void moveElementsInArray(Object arg, int index) {
        /*прохожу по массиву descending с последнего элемента length - 1
        до index
        i = i - 1
         */
        for (int i = args.length - 1; i > index; i--) {
            args[i] = args[i - 1];
        }
        //в заданный индекс присваиваю строку arg
        args[index] = (String) arg;
    }

    @Override
    public String toString() {
        return Arrays.toString(args);
    }
}