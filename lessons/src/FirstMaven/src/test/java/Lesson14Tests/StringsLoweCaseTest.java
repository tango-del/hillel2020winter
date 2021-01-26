package Lesson14Tests;

import Lesson14.OutputStringsLowCase;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class StringsLoweCaseTest {
    //static OutputStringsLowCase test;
    static List<String> arr1;
    static List<String> arr2;
    static List<String> arr3; // null
    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    static void initArray() {
        System.setOut(new PrintStream(outputStreamCaptor));
        arr1 = new ArrayList<>();
        arr1.add("Mark");
        arr1.add("sped");
        arr1.add("Octavius");
        arr1.add("ODWw");
        arr1.add("hsee");
        arr1.add("spEd");
        arr1.add("FHGI");
        arr1.add("halk");
        arr1.add("rufallo");

        arr2 = new ArrayList<>();

    }

    @Test
    public void checkLoweCase() {
        System.out.println("---test: checkLoweCase---");
        //check return false
        Assertions.assertFalse(OutputStringsLowCase.checkLoweCase("Dwa"));
        //check return true
        Assertions.assertTrue(OutputStringsLowCase.checkLoweCase("gesaw"));
        //check throw
        Assertions.assertThrows(NullPointerException.class,
                () -> OutputStringsLowCase.checkLoweCase(null));
    }

    @Test
    public void checkPrintStrings() {
        //check throw
        Assertions.assertThrows(NullPointerException.class, () -> OutputStringsLowCase.printStringLowCase(arr3));

        OutputStringsLowCase.printStringLowCase(arr1);
        Assertions.assertEquals("sped hsee halk", outputStreamCaptor.toString().trim());
        Assertions.assertNotEquals("sped hsee halk rufallo", outputStreamCaptor.toString().trim());

        //work only if .forEach(System.out::println);
        //Assertions.assertEquals("sped\r\n"+"hsee\r\n"+"halk", outputStreamCaptor.toString().trim());
        //Assertions.assertNotEquals("sped\r\n"+"hsee\r\n"+"halk\r\n"+"rufallo", outputStreamCaptor.toString().trim());
    }

    @AfterAll
    public static void tearDown() {
        System.setOut(System.out);
    }
}