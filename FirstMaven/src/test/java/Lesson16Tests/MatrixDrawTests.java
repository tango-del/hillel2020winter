package Lesson16Tests;

import Lesson16.MatrixDraw;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MatrixDrawTests {
    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    static void init() {
        System.setOut(new PrintStream(outputStreamCaptor));
        }


    @Test
    public void checkPrintMatrix() {
        MatrixDraw.drawNumbersMatrix("6905");
        Assertions.assertEquals(" $$$$$   $$$$$   $$$$$  $$$$$$$ \n" +
                                        "$$      $$   $$ $$   $$ $$      \n" +
                                        "$$$$$$$  $$$$$$ $$   $$ $$$$$$$ \n" +
                                        "$$   $$      $$ $$   $$      $$ \n" +
                                        "$$   $$ $$   $$ $$   $$      $$ \n" +
                                        " $$$$$   $$$$$   $$$$$  $$$$$$$ \n",
                outputStreamCaptor.toString().replaceAll("\r", ""));
        Assertions.assertNotEquals(" $$$$$  $$$$$$  \n" +
                                             "$$   $$      $$ \n" +
                                             " $$$$$       $$ \n" +
                                             "$$   $$ $$$$$$$ \n" +
                                             "$$   $$ $$      \n" +
                                             " $$$$$  $$$$$$$ \n",
                outputStreamCaptor,toString().replaceAll("\r", ""));

    }

    @Test
    public void checkThrows() {
        Assertions.assertThrows(NullPointerException.class, () -> MatrixDraw.drawNumbersMatrix(null));
        Assertions.assertThrows(NullPointerException.class, () -> MatrixDraw.drawNumbersMatrix(""));
        Assertions.assertThrows(RuntimeException.class, () -> MatrixDraw.drawNumbersMatrix("1f2"));
        Assertions.assertThrows(RuntimeException.class, () -> MatrixDraw.drawNumbersMatrix("Ee3"));
    }

    @AfterAll
    static void endTests() {
        System.setOut(System.out);
    }
}
