import Collection.StringList;
import Exceptions.IndexOutOfBoundException;
import org.junit.jupiter.api.*;

//TODO почему тесты выполняются не последовательно

public class StringListTest {
    //TODO почитать еще раз про static
    static StringList arr;

    @BeforeAll
    static void initArrayForTests() {
        arr = new StringList();
        //Assertions.assertNotNull(arr.getArgs());
        for (int i = 0; i < arr.getArgs().length; i++) {
            arr.add(i + 1);
        }
    }

    @Test
    public void checkContains() {
        System.out.println(arr);
        System.out.println("---test: checkContains---");
        Assertions.assertFalse(arr.contains("1234"));
        Assertions.assertTrue(arr.contains("5"));
        Assertions.assertFalse(arr.contains("test message"));
    }

    @Test
    public void checkContainsInNewCollection() {
        System.out.println("---test: checkContainsInNewCollection---");
        StringList temp = new StringList();
        temp.add("1");
        Assertions.assertTrue(arr.contains(temp, arr.getArgs()[0]));
        Assertions.assertFalse(arr.contains(temp, arr.getArgs()[4]));
    }

    @Test
    public void checkRemoveDuplicates() {
        System.out.println("---test: checkContainsInNewCollection---");
        StringList temp;
        Assertions.assertNotNull(temp = arr.removeDuplicates(arr));
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
    }
}
