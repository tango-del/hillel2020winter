package lesson12practise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResources {
    public static void main(String[] args) {
        consoleManualClose();
        //consoleAutoClose();
    }

    public static void consoleManualClose() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("test.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void consoleAutoClose() {
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




    }
}
