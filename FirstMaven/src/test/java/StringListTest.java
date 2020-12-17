import Collection.StringList;
import Exceptions.IndexOutOfBoundException;
import org.junit.jupiter.api.*;

//TODO почему тесты выполняются не последовательно
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
        }
        temp.add("1");
        temp.add("2");
        temp.add("3");
    }

    @Order(1)
    @Test
    public void check1ContainsInNewCollection() {
        System.out.println("---test: checkContainsInNewCollection---");
        Assertions.assertTrue(arr.contains(temp, "3"));
        Assertions.assertFalse(arr.contains(temp, arr.getArgs()[4]));
        Assertions.assertFalse(arr.contains(temp, "test"));
    }

    @Order(2)
    @Test
    public void check2RemoveDuplicates() {
        System.out.println("---test: check2RemoveDuplicates---");
        temp.add("2");
        temp.add("1");
        temp.add("3");
        temp.add("4");
        temp.add("3");
        temp.add("5");
        temp.add("5");
        StringList uniqueArr = temp.removeDuplicates(temp);
        StringList testArr = new StringList();
        testArr.add("1");
        testArr.add("2");
        testArr.add("3");
        testArr.add("4");
        testArr.add("5");
        Assertions.assertTrue(uniqueArr.compare(testArr));
        testArr.add("5");
        Assertions.assertFalse(uniqueArr.compare(testArr));
    }

    @Order(3)
    @Test
    public void check3Contains() {
        System.out.println("---test: checkContains---");
        Assertions.assertFalse(arr.contains("1234"));
        Assertions.assertTrue(arr.contains("5"));
        Assertions.assertFalse(arr.contains("test message"));
    }

    @Order(4)
    @Test
    public void check4RemoveByObject() {
        System.out.println("---test: checkRemoveByObject---");
        Assertions.assertTrue(arr.remove("1"));
        Assertions.assertFalse(arr.remove("test message"));
    }

    @Order(5)
    @Test
    public void check5RemoveByIndex() {
        System.out.println("---test: checkRemoveByIndex---");
        Assertions.assertThrows(IndexOutOfBoundException.class, () -> arr.remove(-1));
        Assertions.assertThrows(IndexOutOfBoundException.class, () -> arr.remove(155));
        Assertions.assertTrue(arr.remove(1));
    }

    @Order(6)
    @Test
    public void check6Add() {
        System.out.println("---test: checkAdd---");
        Assertions.assertTrue(arr.add(13));
    }

    @Order(7)
    @Test
    public void check7AddToIndex() {
        System.out.println("---test: checkAddToIndex---");
        Assertions.assertThrows(IndexOutOfBoundException.class ,() -> arr.add(13, 14));
        Assertions.assertThrows(IndexOutOfBoundException.class ,() -> arr.add(13, -1));
        Assertions.assertTrue(arr.add(13, 2));
    }

    @Order(8)
    @Test
    public void check8Get() {
        System.out.println("---test: checkGet---");
        Assertions.assertThrows(IndexOutOfBoundException.class, () -> arr.get(-1));
        Assertions.assertNotNull(arr.get(3));
        arr.getArgs()[3] = null;
        Assertions.assertNull(arr.get(3));
    }

    @Order(9)
    @Test
    public void check9Compare() {
        System.out.println("---test: checkCompare---");
        Assertions.assertFalse(arr.compare(temp));
        Assertions.assertTrue(arr.compare(arr));
        Assertions.assertTrue(temp.compare(temp));
    }

    @Order(10)
    @Test
    public void check10IsClearedArray() {
        System.out.println("---test: checkIsClearedArray---");
        Assertions.assertTrue(arr.size() > 0);
        Assertions.assertTrue(arr.clear());
        Assertions.assertEquals(arr.size(), 0);
    }

    @Order(11)
    @Test
    public void check11Size() {
        System.out.println("---test: checkSize---");
        //arr.clear();
        Assertions.assertEquals(0, arr.size());
        Assertions.assertFalse(arr.size() > 0);
    }
}
