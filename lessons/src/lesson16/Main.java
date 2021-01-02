package lesson16;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //String testString = "394";
        test();
        //result(testString);


        char[] start = new char[6];
        char[] temp = new char[]{'1', '2', '3', '4', '5', '6'};
        System.arraycopy(temp, 0, start, 1, 6);
        System.out.println(Arrays.toString(start));

    }

    private static int countJ;

    public static void result(String str) throws RuntimeException {
        if (checkForNumbers(str)) {
            throw new RuntimeException("Invalid number. Enter between 0 - 9");
        }
        int count = str.length();

        char[][] matrixTest = new char[6][7 * count + count];

        for (int k = 0; k < str.length(); k++) {
            char[][] temp = getNumberArray(str.charAt(k));
            for (int i = 0; i < temp.length; i++) {
                System.arraycopy(temp[i], 0, matrixTest[i], countJ, 7);
            }
            countJ += 7;
            addSpaceBetweenNumbers(matrixTest);

            //fillOneArrayWithAnother(matrixTest, temp, countI, countJ);

        }
        print(matrixTest);
    }

    private static void addSpaceBetweenNumbers(char[][] matrixTest) {
        for (int i = 0; i < matrixTest.length; i++) {
            matrixTest[i][countJ] = ' ';
            matrixTest[i][countJ] = ' ';
            matrixTest[i][countJ] = ' ';
            matrixTest[i][countJ] = ' ';
            matrixTest[i][countJ] = ' ';
            matrixTest[i][countJ] = ' ';
        }
        ++countJ;
    }

    private static void fillOneArrayWithAnother(char[][] matrixTest, char[][] temp, int countI, int countJ) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                matrixTest[countI][countJ] = temp[i][j];
                countJ++;
            }
            countI++;
            countJ = 0;
        }
    }

    private static boolean checkForNumbers(String str) throws NullPointerException {
        if (str == null) {
            throw new NullPointerException("String null");
        }
        for (int i = 0; i < str.length(); i++) {
            //if (!Character.isDigit(str.charAt(i)))
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return true;
            }
        }
        return false;
    }

    private static char[][] getNumberArray(char number) throws RuntimeException {
        switch (number) {
            case '0':
                final char[][] matrixZero = new char[][]{
                        {' ', '$', '$', '$', '$', '$', ' '},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {' ', '$', '$', '$', '$', '$', ' '},};
                return matrixZero;
            case '1':
                final char[][] matrixOne = new char[][]{
                        {' ', ' ', ' ', '$', '$', ' ', ' '},
                        {'$', '$', '$', '$', '$', ' ', ' '},
                        {' ', ' ', ' ', '$', '$', ' ', ' '},
                        {' ', ' ', ' ', '$', '$', ' ', ' '},
                        {' ', ' ', ' ', '$', '$', ' ', ' '},
                        {' ', ' ', '$', '$', '$', '$', ' '},};
                return matrixOne;
            case '2':
                final char[][] matrixTwo = new char[][]{
                        {'$', '$', '$', '$', '$', '$', ' '},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', '$', '$', '$', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', ' ', ' '},
                        {'$', '$', '$', '$', '$', '$', '$'},};
                return matrixTwo;
            case '3':
                final char[][] matrixThree = new char[][]{
                        {' ', ' ', '$', '$', '$', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', '$', '$', '$', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', '$', '$', '$', '$', '$'},};
                return matrixThree;
            case '4':
                final char[][] matrixFour = new char[][]{
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', '$', '$', '$', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},};
                return matrixFour;
            case '5':
                final char[][] matrixFive = new char[][]{
                        {'$', '$', '$', '$', '$', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', ' ', ' '},
                        {'$', '$', '$', '$', '$', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', '$', '$', '$', '$', '$'},};
                return matrixFive;
            case '6':
                final char[][] matrixSix = new char[][]{
                        {' ', '$', '$', '$', '$', '$', ' '},
                        {'$', '$', ' ', ' ', ' ', ' ', ' '},
                        {'$', '$', '$', '$', '$', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {' ', '$', '$', '$', '$', '$', ' '},};
                return matrixSix;
            case '7':
                final char[][] matrixSeven = new char[][]{
                        {'$', '$', '$', '$', '$', '$', '$'},
                        {' ', ' ', ' ', ' ', '$', '$', ' '},
                        {' ', ' ', ' ', '$', '$', ' ', ' '},
                        {' ', ' ', '$', '$', ' ', ' ', ' '},
                        {' ', '$', '$', ' ', ' ', ' ', ' '},
                        {'$', '$', ' ', ' ', ' ', ' ', ' '}};
                return matrixSeven;
            case '8':
                final char[][] matrixEight = new char[][]{
                        {' ', '$', '$', '$', '$', '$', ' '},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {' ', '$', '$', '$', '$', '$', ' '},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {' ', '$', '$', '$', '$', '$', ' '}};
                return matrixEight;
            case '9':
                final char[][] matrixNine = new char[][]{
                        {' ', '$', '$', '$', '$', '$', ' '},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {' ', '$', '$', '$', '$', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {' ', '$', '$', '$', '$', '$', ' '}};
                return matrixNine;
            default:
                throw new RuntimeException("Invalid number. Enter between 0 - 9");
        }
    }

    public static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void test() {
        char[][] matrixSeven = new char[5][5];
        for (int i = 0; i < matrixSeven.length; i++) {
            for (int j = matrixSeven[i].length - 1; j >= 0; j--) {
                if (i == 0) {
                    matrixSeven[i][j] = '*';
                } else if (i == j) {
                    matrixSeven[i][j] = '*';
                } else {
                    //fill each element with 'space' 32 character 46
                    matrixSeven[i][j] = 32;
                }
            }
        }
        for (int i = 0; i < matrixSeven.length; i++) {
            for (int j = matrixSeven[i].length - 1; j >= 0; j--) {
                System.out.print(matrixSeven[i][j]);
            }
            System.out.println();
        }
    }
}
