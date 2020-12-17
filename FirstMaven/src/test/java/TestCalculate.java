import Examples.Calculate;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCalculate {

    @BeforeAll
    public static void beforeClass() {
        System.out.println("before class");
    }

    @BeforeEach
    public void before() {
        System.out.println("-- before");
    }

    @Test
    public void sumPos() {
        //System.out.println("----- test sumPos");
        Assertions.assertEquals(5, Calculate.sum(2, 2), "----- test sumPos");
    }

    @Test
    public void sumNeg() {
        System.out.println("----- test sumNeg");
        Assertions.assertNotEquals(4, Calculate.sum(2, 3));
    }

    @Test
    public void multPos() {
        System.out.println("------- test multPos");
        Assertions.assertEquals(9, Calculate.mult(3, 3));
    }

    @Test
    public void multNeg() {
        System.out.println("----- test multNeg");
        Assertions.assertNotEquals(7, Calculate.mult(3, 3));
    }

    @Test
    public void texPos() {
        System.out.println("----- test texPos");
        Assertions.assertTrue(Calculate.tex(2, 3));
    }

    @Test
    public void texNeg() {
        System.out.println("----- test texNeg");
        Assertions.assertFalse(Calculate.tex(3, 2));
    }

    @Test
    public void div() {
        System.out.println("---- test div");
        Assertions.assertEquals(1, Calculate.div(2, 2));
    }

    @Test
    public void divZeroBtAny() {
        System.out.println("---- test divZeroBtAny");
        Assertions.assertEquals(0, Calculate.div(0, 2));
    }

    @Test
    public void divZero() {
        System.out.println("----- testDivWithThrows");
        Assertions.assertThrows(ArithmeticException.class, () -> Calculate.div(2, 0));
    }

    @RepeatedTest(10)
    public void repeatedTest() {
        System.out.println("test repeat");
    }


    @AfterEach
    public void after() {
        System.out.println("-- after");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("after class");
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void paramTestSub (int arg) {
        System.out.println("---- parameterizedTest");
        assertTrue(Calculate.sub(-12221, arg) > 0);
    }
    private void assertTrue(boolean b) {}
}
