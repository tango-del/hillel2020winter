package lesson7;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "Sobik";

        char[] arrstr = new char[str.length() + 1];
        String newStr = copySymbols(str, arrstr);
        char add = 'l';
        byte startMoveSymbolsAt = 2;
        char[] test = newStr.toCharArray();
        for (int i = test.length - 1; i > startMoveSymbolsAt; i--) {
            test[i] = test[i - 1];
        }
        test[startMoveSymbolsAt] = add;
        String newff = Arrays.toString(test);
        System.out.println(newff);

    }

    public static String copySymbols(String str, char[] arrstr) {
        for (int i = 0; i < str.length(); i++) {
            arrstr[i] = str.charAt(i);
        }
        return new String(arrstr);
    }
}

class Test implements makeString {

}
