package lesson2;

import java.util.Scanner;
/*
Программу, которая предлагает пользователю ввести сумму денежного вклада в гривнах,
процент годовых, которые выплачивает банк, длительность вклада (лет).
Вывести накопленную сумму денег за каждый год и начисленные проценты.
 */

public class Task3 {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("summa vklada");
//        double summaVklada = scanner.nextDouble();
//        System.out.println("procentnaya stavka");
//        double procentGodovix = scanner.nextDouble() / 100;
//        System.out.println(procentGodovix);
//        System.out.println("srok vklada");
//        double srokVklada = scanner.nextDouble();
        byte srokVklada = 4;
        float summaVklada = 15_000;
        float procentGodovix = 8f / 100;
//        double adv = (summaVklada * procentGodovix * srokVklada / 365) / 100;
        float itogSumma = (float) (summaVklada * Math.pow((1 + procentGodovix / 1), srokVklada));
        float nakoplenSumm = itogSumma - summaVklada;
        System.out.printf("Итог: %s", itogSumma);
        System.out.println();
        System.out.printf("Накопленная сумма: %s", nakoplenSumm);

        float[] test = new float[(int) srokVklada + 1];
        for (int i = 0; i < test.length; i++) {
            float blabla = summaVklada * (1 + procentGodovix);
            float temp = blabla - summaVklada;
            summaVklada = blabla;
            System.out.printf("%s год - %s", i, blabla);
            System.out.print('\n');
            System.out.printf("Начисленные проценты - %s", temp);
            System.out.print('\n');
        }
    }
}