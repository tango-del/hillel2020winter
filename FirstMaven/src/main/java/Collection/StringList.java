package Collection;

import Exceptions.IndexOutOfBoundException;
import Exceptions.NoSuchObjectException;
import java.util.Arrays;
import java.util.Objects;

public class StringList implements StringCollection {
    private int count;
    private Object[] args;

    public StringList() {
        args = new String[10];
    }

    public Object[] getArgs() {
        return args;
    }

//    @Override
//    public boolean contains(Object str) {
//        //String abc = String.valueOf(str);
//        boolean result = false;
//        try {
//            result = checkObjectContains((String) str);
//        } catch (NoSuchObjectException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
////        for (int i = 0; i < args.length; i++) {
////            if (args[i] == str) {
////                result = true;
////                break;
////            }
////        }
//        return result;
//    }

    @Override
    public boolean contains(Object str) {
        if (str == null) {
            for (int i = 0; i < count; i++) {
                if (args[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                //TODO args[i].equals(str) - not same
                if (str.equals(args[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean contains(StringList temp, Object str) {
        boolean result = false;
        for (int i = 0; i < temp.size(); i++) {
//            if (temp.getArgs()[i] == str) {
//                return true;
//                //break;
//            }
            if (str.equals(temp.getArgs()[i])) {
                return true;
            }
        }
        return result;
    }

    public StringList removeDuplicates(StringList array) {
        StringList temp = new StringList();
        for (int i = 0; i < array.size(); i++) {
            if (!array.contains(temp, args[i])) {
                temp.add(array.getArgs()[i]);
            }
        }
        return temp;
    }

    @Override
    public boolean remove(Object str) {
//        try {
//            checkObjectContains((String) str);
//        } catch (NoSuchObjectException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }

        /*
        Была проблема в прошлой реализации в том что index = 0
        и если в цикле условине не было верным то вызывало метод decreaseArray(index)
        и удаляло элемент под 0-м индексом
        Здесь же идёт провека сперва на что такой объект есть в массиве, если нету то
        return false
         */
        if (contains(str)) {
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
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(int index) throws IndexOutOfBoundException {
        if (checkIndex(index)) {
            throw new IndexOutOfBoundException("Incorrect index value");
        }
//        try {
//            checkIndex(index);
//        } catch (IndexOutOfBoundException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
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
        args[count++] = String.valueOf(str);
        return true;
    }

    @Override
    public boolean add(Object str, int index) throws IndexOutOfBoundException {
//        if (index < 0 || index > count) {
//            System.out.println("Incorrect index value");
//            return false;
//        }
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundException("Incorrect index value");
        }
//        try {
//            checkIndex(index);
//        } catch (IndexOutOfBoundException e) {
//            throw new IndexOutOfBoundException("Index Out Of Bound Exception");
//            //System.out.println(e.getMessage());
//            //return false;
//        }
        if (count >= args.length || count + 1 >= args.length) {
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

//    @Override
//    public int get(Object str) throws NullPointerException {
//        int result = 0;
//        try {
//            checkObjectContains(String.valueOf(str));
//        } catch (NoSuchObjectException e) {
//            //result = "No matches";
//            //return result;
//            System.out.println("error");
//        }
//        for (int i = 0; i < args.length; i++) {
//            if (args[i] == str) {
//                //return String.valueOf(i);
//                result = i;
//            }
//        }
//        return result;
//        //return "No matches";
//    }

    @Override
    public Object get(int index) throws IndexOutOfBoundException {
//        try {
//            checkIndex(index);
//        } catch (IndexOutOfBoundException e) {
//            return "Index out of exception";
//        }
        if (checkIndex(index)) {
            throw new IndexOutOfBoundException("Incorrect index value");
        }
        return args[index];
//        if (index < args.length) {
//            return args[index];
//        }
//        return "Index out of exception";
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
        for (int i = count + 1; i > index; i--) {
            args[i] = args[i - 1];
        }
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index > count) {
            return true;
            //throw new IndexOutOfBoundException("Index Out Of Bound Exception");
        }
        return false;
    }

//    private boolean checkObjectContains(String str) throws NoSuchObjectException {
//        boolean result = false;
//        for (int i = 0; i < args.length; i++) {
//            //TODO why (args[i] == str) -> false
//            if (args[i].equals(str)) {
//                result = true;
//                return result;
//            }
//        }
//        if (result == false) {
//            throw new NoSuchObjectException(str);
//        }
//        return result;
//    }
}