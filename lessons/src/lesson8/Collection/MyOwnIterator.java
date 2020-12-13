package lesson8.Collection;

import java.util.Iterator;

public class MyOwnIterator implements Iterator {
    private int count;
    private int lastReturned = -1;
    private Object[] array;

    public MyOwnIterator(Object[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return count < array.length;
    }

    @Override
    public String toString() {
        int i = 0;
        StringBuilder a = new StringBuilder();
        a.append("[");
        while (hasNext()) {
            if (next() != null) {
                a.append(array[i]).append(", ");
                ++i;
            }
        }
        a.append("]");
        count = 0;
        lastReturned = -1;
        String result = new String(a);

        return result;
    }

    @Override
    public Object next() {
        int i = count;
        if (count >= array.length){
            System.out.println("NoSuchElementException");
        }
        count = i + 1;
        lastReturned += 1;
        return array[i];
    }

    public Object[] getArray() {
        return array;
    }

    @Override
    public void remove() {
        if (lastReturned < 0) {
            System.out.println("IllegalStateException");
        }
        array = decreaseArray(lastReturned);
        count = 0;
        lastReturned = -1;
    }

    private Object[] decreaseArray(int index) {
        Object[] newArray = new Object[array.length - 1];
        copyToDecreasedArray(newArray, index);
        return newArray;
    }

    private void copyToDecreasedArray(Object[] newArray, int index) {
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            }
            else if (i >= index) {
                newArray[i] = array[i + 1];
            }
        }
    }

}