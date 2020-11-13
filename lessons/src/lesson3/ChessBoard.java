package lesson3;
/*
Вывести на экран шахматную доску 8х8 в виде 2 мерного массива (W - белые клетки , B - черные клети)
 */

public class ChessBoard {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        char[][] board = new char[8][8];
        initArray(board);
        printArray(board);
    }

    //fill all elements with symbols due to statements
    public static void initArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0 || i == 1) {
                    arr[i][j] = 'B';
                } else if (i == 6 || i == 7){
                    arr[i][j] = 'W';
                } else {
                    arr[i][j] = '*';
                }
            }
        }
    }

    //output array
    public static void printArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
