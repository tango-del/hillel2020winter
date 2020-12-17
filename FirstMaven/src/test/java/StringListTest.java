import Collection.StringList;
import Exceptions.IndexOutOfBoundException;
import org.junit.jupiter.api.*;

//TODO почему тесты выполняются не последовательно
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class StringListTest {
    //TODO почитать еще раз про static
    static StringList arr;
    static StringList temp;

    @BeforeAll
    static void initArrayForTests() {
        temp = new StringList();
        arr = new StringList();
        for (int i = 0; i < arr.getArgs().length; i++) {
            arr.add(i + 1);
            if (i < 3) {
                temp.add(i + 1);
            }
        }
    }

    @Test
    public void check1ContainsInNewCollection() {
        System.out.println("---test: checkContainsInNewCollection---");
        Assertions.assertTrue(arr.contains(temp, "3"));
        Assertions.assertFalse(arr.contains(temp, arr.getArgs()[4]));
        Assertions.assertFalse(arr.contains(temp, "test"));
    }

    @Test
    public void check2RemoveDuplicates() {
        /*
        что это тест делает???
        тут надо создать коллекцию
        прогнать на удаление дубликатов
        и потом сравнить с эталонным резельтатом
         */
        System.out.println("---test: check2RemoveDuplicates---");
        temp.add("2");
        temp.add("1");
        temp.add("3");
        temp.add("4");
        temp.add("3");
        temp.add("5");
        temp.add("5");
        System.out.println(temp);
        StringList newArray = temp.removeDuplicates(temp);
        System.out.println(newArray);
        Assertions.assertArrayEquals(newArray.getArgs(), temp.getArgs());
        //Assertions.assertNotNull(temp = arr.removeDuplicates(arr));
    }

    @Test
    public void check3Contains() {
        System.out.println(arr);
        System.out.println("---test: checkContains---");
        Assertions.assertFalse(arr.contains("1234"));
        Assertions.assertTrue(arr.contains("5"));
        Assertions.assertFalse(arr.contains("test message"));
    }

    @Test
    public void checkRemoveByObject() {
        System.out.println(arr);
        System.out.println("---test: checkRemoveByObject---");
        Assertions.assertTrue(arr.remove("1"));
        Assertions.assertFalse(arr.remove("test message"));
        System.out.println(arr);
    }

    @Test
    public void checkRemoveByIndex() {
        System.out.println(arr);
        System.out.println("---test: checkRemoveByIndex---");
        Assertions.assertThrows(IndexOutOfBoundException.class, () -> arr.remove(-1));
        Assertions.assertThrows(IndexOutOfBoundException.class, () -> arr.remove(155));
        Assertions.assertTrue(arr.remove(1));
        System.out.println(arr);
    }

    @Test
    public void checkAdd() {
        System.out.println(arr);
        System.out.println("---test: checkAdd---");
        Assertions.assertTrue(arr.add(13));
        System.out.println(arr);
        //Assertions.assertFalse(arr.add(13, 12));
    }

    @Test
    public void checkAddToIndex() {
        System.out.println(arr);
        System.out.println("---test: checkAddToIndex---");
        Assertions.assertThrows(IndexOutOfBoundException.class ,() -> arr.add(13, 14));
        Assertions.assertThrows(IndexOutOfBoundException.class ,() -> arr.add(13, -1));
        Assertions.assertTrue(arr.add(13, 2));
        System.out.println(arr);
    }


    @Test
    public void checkGet() {
        System.out.println(arr);
        System.out.println("---test: checkGet---");
        Assertions.assertThrows(IndexOutOfBoundException.class, () -> arr.get(-1));
        Assertions.assertNotNull(arr.get(3));
        arr.getArgs()[3] = null;
        Assertions.assertNull(arr.get(3));
    }

    @Test
    public void checkSize() {
        System.out.println("---test: checkSize---");
        Assertions.assertNotEquals(0, arr.size());
    }


    @Test
    public void checkIsClearedArray() {
        System.out.println("---test: checkIsClearedArray---");
        Assertions.assertTrue(arr.clear());
        Assertions.assertEquals(arr.size(), 0);
    }
}
