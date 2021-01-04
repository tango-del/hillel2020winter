package Lesson16;

public class MatrixDraw {
    /**
     * @countJ хранит актуальный индекс куда будут
     * записываться символы в двумерном массиве
     */
    private static int countJ;

    /**
     * Метод проверяет на то что в String str записаны только цифры, если @checkForNumbers
     * возвращает true тогда выкидывает исключение
     * count - записывает длину str
     *
     * @param str
     * @throws RuntimeException
     */
    public static void drawNumbersMatrix(String str) throws RuntimeException {
        if (checkForNumbers(str)) {
            throw new RuntimeException("Invalid number. Enter between 0 - 9");
        }

        int count = str.length();

        /*
        Все массивы с цифрами имеют одинаковую длинну (6 строк и 7 столбцов)
        Создаётся массив с длинной ссылок на массив: 6
        колличество столбцов зависит от колличества символов в String str
        () + count для добавления пробелов между матрицами цифр
         */
        char[][] matrixTest = new char[6][(7 * count) + count];

        // проход циклом по длине String str 36
        for (int k = 0; k < str.length(); k++) { //k = 0 -> 6
            /*
            на каждой итерации temp вызывает @getNumberArray, отправляет каждый
            символ str и записывает ссылку на массив которую возвращает метод
             */
            char[][] temp = getNumberArray(str.charAt(k));

            /*
            У каждой строки двумерного массива вызывается @System.arraycopy
            temp[i] - массив у которого будет копировать значения
            srcPos - начальный индекс с которого начинается копирование
            matrixTest[i] - в какой массив будет копировать
            countJ - с какого индекса будет записывать
            temp[i].length - сколько элементов будет записывать, в данном случае весь массив
             */
            for (int i = 0; i < temp.length; i++) {
                System.arraycopy(temp[i], 0, matrixTest[i], countJ, temp[i].length);
            }

            /*
            перед новой итерации перезаписывает @countJ что бы хранил последний свободный индекс
             */
            countJ += temp[0].length; // temp[0].length = 7

            addSpaceBetweenNumbers(matrixTest);
        }

        /*
        вывод в консоль
         */
        print(matrixTest);

        /*
        Обнуляет @countJ
         */
        clear();
    }

    /**
     * Выводит в консоль матрицу двумерного массива
     *
     * @param matrix
     */
    private static void print(char[][] matrix) {
        /*
        for (char [] a : matrix) {
            for (char b : a) {
                System.out.println(b);
            }
        }
         */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Обнуляет countJ для повторной отрисовки
     */
    private static void clear() {
        countJ = 0;
    }

    /**
     * Добавляет пробелы в каждый индекс что бы между цифрами был разделитель
     *
     * @param matrixTest
     */
    private static void addSpaceBetweenNumbers(char[][] matrixTest) {
        for (int i = 0; i < matrixTest.length; i++) {
            matrixTest[i][countJ] = ' '; // char 32
            matrixTest[i][countJ] = ' ';
            matrixTest[i][countJ] = ' ';
            matrixTest[i][countJ] = ' ';
            matrixTest[i][countJ] = ' ';
            matrixTest[i][countJ] = ' ';
        }
        /*
        увеличивает @countJ что бы хранить свободный индекс
         */
        ++countJ;
    }

    /**
     * Этот метод возвращает boolean значение:
     * Проверяет на то что String лпроинициализирован или не пустой, в противном
     * случае выкидывает исключение;
     * Проверяет что в String str все символы записаны в виде цифр,
     * true - если хоть один символ не соответствует условию
     * false - если совпадений не быо
     *
     * @param str
     * @return
     * @throws NullPointerException
     */
    private static boolean checkForNumbers(String str) throws NullPointerException {
        if (str == null || str.isEmpty()) {
            throw new NullPointerException("String null");
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                //if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод возвращает двумерный массив в соответствии символа @number
     * если соответствий нету выкидывает исключение
     *
     * @param number
     * @return
     * @throws RuntimeException
     */
    private static char[][] getNumberArray(char number) throws RuntimeException {
        switch (number) {
            case '0':
                final char[][] matrixZero = new char[][]{
                        {' ', '$', '$', '$', '$', '$', ' '},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {' ', '$', '$', '$', '$', '$', ' '}};
                return matrixZero;
            case '1':
                final char[][] matrixOne = new char[][]{
                        {' ', ' ', ' ', '$', '$', ' ', ' '},
                        {'$', '$', '$', '$', '$', ' ', ' '},
                        {' ', ' ', ' ', '$', '$', ' ', ' '},
                        {' ', ' ', ' ', '$', '$', ' ', ' '},
                        {' ', ' ', ' ', '$', '$', ' ', ' '},
                        {' ', ' ', '$', '$', '$', '$', ' '}};
                return matrixOne;
            case '2':
                final char[][] matrixTwo = new char[][]{
                        {'$', '$', '$', '$', '$', '$', ' '},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', '$', '$', '$', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', ' ', ' '},
                        {'$', '$', '$', '$', '$', '$', '$'}};
                return matrixTwo;
            case '3':
                final char[][] matrixThree = new char[][]{
                        {' ', ' ', '$', '$', '$', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', '$', '$', '$', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', '$', '$', '$', '$', '$'}};
                return matrixThree;
            case '4':
                final char[][] matrixFour = new char[][]{
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', '$', '$', '$', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'}};
                return matrixFour;
            case '5':
                final char[][] matrixFive = new char[][]{
                        {'$', '$', '$', '$', '$', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', ' ', ' '},
                        {'$', '$', '$', '$', '$', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {' ', ' ', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', '$', '$', '$', '$', '$'}};
                return matrixFive;
            case '6':
                final char[][] matrixSix = new char[][]{
                        {' ', '$', '$', '$', '$', '$', ' '},
                        {'$', '$', ' ', ' ', ' ', ' ', ' '},
                        {'$', '$', '$', '$', '$', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {'$', '$', ' ', ' ', ' ', '$', '$'},
                        {' ', '$', '$', '$', '$', '$', ' '}};
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
}
