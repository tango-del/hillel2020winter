package lesson8.Collection;

import java.util.Arrays;
import java.util.Objects;

public class StringList implements StringCollection {
    private int count;

    private Object[] args;
    /*
    дальше идём по пунктам какие методы должны быть реализованы в твой коллекции
boolean add(Object str);

метод на вход принимает объект в виде строки и добавляет его в последний свободный индекс в массиве

при первом вызове метода твой массив выглядит:
[ null, null, nul,..... nul]
так как ты добавляешь первый раз то у тебя свободный 0 индекс по этому у тебя массив выглядит:
[ string, null, null.... null ]
при добавлении еще одной строки:
[ string, string, null.... null ]

и так у тебя должно происходить до тех пор пока ты не заполнишь все свободные индексы:
[ string, string, string.... string ]

При попытке добавить еще один элемент массив расширяется по той формуле

В результате твой метод add(Object str)

должен делать 2 вещи:
1 - проверка на то что есть свободный индекс куда можно положить строку
если свободного индекса нету то расширяешь массив,
2 - если есть свободный индекс то записываешь в него строку


------------------------------

Каким образом ArrayList знает свободный индекс?
У него под капотом помимо твоего массива есть еще переменная int count,
поэтому этот (count) всегда должен знать номер индекса в который он может сохранить значение

Если подытожить то твоя коллекция хранит в себе помимо методов так же массив в который она будет сохранять значения и
перменная count которая будет хранить в себе свободный индекс

если снова вернуться к моменту когда массив полностью пустой
[ null, null, nul,..... nul] то на этом этапе (count) хранит значение 0 потому что свободен 0 индекс
если ты вызываешь метод add(Object str) то
помимо того что ты добавляешь строку в массив ты так же инкрементишь (count) => ++count
[ string, null, null.... null ] поэтому в этом случае у тебя count = 1

Каким образом ты можешь проверять нужно ли тебе расширять массив?
Так как у тебя count хранит текущий свободный индекс у тебя должна быть проверка
на то что твой count не выходит за рамки твоего массива или:
if (count >= args.length) {
  //расширяем массив
 }
 если же условие false
 то args[count] = str;
 и потом делаешь инкремент count:
 ++count;

 public boolean add(Object str) {

        if (count >= args.length) {
            //расширяем массив
        }
        args[count] = str;
        ++count;
        return true;
    }
     */

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

    public StringList removeDuplicates(StringList array) {
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
        /*
        -проверка что указанный индекс не выходит за рамки 0 и не больше значения count потому что нельзя сохранять значения пропуская пустой индекс
        -следующая проверка проверяет что текущий count не выходит за рамки массива,
        а так же следующий индекс после count, если хоть одно совпадение то расширяем массив
        -проверка что указанный индекс является пустым а так же что индекс не больше count
        если истина то в заданный индекс записывается строка а так же проверка что следующий индекс так же null то ++count
        -если прошлая проверка false то следующая проверка что текущий индекс уже занят строкой и индекс меншье count
        тогда двигает элементы массива вправо начиная с позиции index
        записывает в текущий индекс строку и увеличивает count
         */
        if (index < 0 || index > count) {
            System.out.println("Incorrect index value");
            return false;
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