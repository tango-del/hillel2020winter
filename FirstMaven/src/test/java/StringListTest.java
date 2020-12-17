import Collection.StringList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//TODO почему тесты выполняются не последовательно

public class StringListTest {
    static StringList arr;

    @BeforeAll
    static void checkArrayNotNull() {
        arr = new StringList();
        Assertions.assertNotNull(arr.getArgs());
        for (int i = 0; i < arr.getArgs().length; i++) {
            arr.add(i + 1);
        }
    }

    //@Disabled
    @Test
    public void checkCountNotNull() {
        System.out.println("---test: checkCountNotNull---");
        //check if returns true
        System.out.println(arr);
        Assertions.assertFalse(arr.contains("1234"));
    }

    @Test
    public void checkIsRemoved() {
        System.out.println("---test: checkIsRemoved---");
        //Integer i = 1;
        Assertions.assertTrue(arr.remove(1));
        Assertions.assertFalse(arr.remove("1"));
        System.out.println("check if removed:");
        Assertions.assertFalse(arr.contains("1"));
        Assertions.assertTrue(arr.remove(1));
        System.out.println(arr);
        Assertions.assertFalse(arr.contains("3"));
    }

    @Test
    public void checkForAdd() {
        System.out.println("---test: checkForAdd---");
        Assertions.assertTrue(arr.add(13));
        Assertions.assertFalse(arr.add(13, 14));
    }

    @Test
    public void checkGetNotNull() {
        System.out.println("---test: checkGetNotNull---");
        Assertions.assertNotNull(arr.get(133));


    }

    @Test
    public void checkSize() {
        System.out.println("---test: checkSize---");
        Assertions.assertNotEquals(0, arr.size());
    }

    //@Disabled
    @Test
    public void checkIsClearedArray() {
        System.out.println("---test: checkIsClearedArray---");
        Assertions.assertTrue(arr.clear());
    }
}
