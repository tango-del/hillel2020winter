package lesson12practise;

import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
//        try {
//            System.err.println("1");
//            if (true) {
//                throw new RuntimeException();
////                throw new Exception();
//            }
//            System.err.println("2");
//        } catch (RuntimeException ex) {
//            System.err.println("3");
//        }
////        catch (Exception e) {
////            e.printStackTrace();
////        }
//        System.err.println("4");
        try {
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            if (x >= 30) {
                throw new Exception("number x must be < 30");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("soft end");
    }
}
