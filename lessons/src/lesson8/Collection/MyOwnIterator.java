package lesson8.Collection;

import java.util.Iterator;

public class MyOwnIterator implements Iterator {
    private int count;
    private int lastNext = -1;
    private final Object[] array;

    public MyOwnIterator(Object[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return count < array.length;
    }

    @Override
    public Object next() {
        int i = count;
        if (count >= array.length){
            System.out.println("NoSuchElementException");
        }
        //count = i + 1;

        return array[count++];
    }

    public Object[] getArray() {
        return array;
    }

    @Override
    public void remove() {
        if (lastNext < 0) {
            System.out.println("IllegalStateException");
        }

        //array = decreaseArray(count);
        //count--;
    }

//    private Object[] decreaseArray(int index) {
//        Object[] newArray = new Object[args.length - 1];
//        copyToDecreasedArray(newArray, index);
//        return newArray;
//    }

//    private void copyToDecreasedArray(Object[] newArray, int index) {
//        for (int i = 0; i < newArray.length; i++) {
//            if (i < index) {
//                newArray[i] = args[i];
//            } else if (i >= index) {
//                newArray[i] = args[i + 1];
//            }
//        }
//    }

}