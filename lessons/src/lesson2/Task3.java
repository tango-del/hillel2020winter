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
        System.out.println("Сумма депозита:");
        float depositAmount = scanner.nextFloat();
        System.out.println("Годовая % ставка:");
        float interestRate = scanner.nextFloat() / 100;
        System.out.println("Длительность вклада (лет):");
        float termDeposit = scanner.nextFloat();

        float finalSum = calcFinalSum(depositAmount, interestRate, termDeposit);

        outputTotalSum(finalSum, depositAmount);

        outputPerYearSum(depositAmount, interestRate, termDeposit);
    }

    //Расчет вклада с ежегодной капитализацией
    public static float calcFinalSum(float depositAmount, float interestRate, float termDeposit) {
        float finalSum = (float) (depositAmount * Math.pow((1 + interestRate / 1), termDeposit));
        return finalSum;
    }


    //Вывод суммарного дохода и накопленной суммы
    public static void outputTotalSum(float finalSum, float depositAmount) {
        float totalAmount = finalSum - depositAmount;
        System.out.printf("Накопленная сумма: %s", finalSum);
        System.out.print('\n');
        System.out.printf("Суммарный доход: %s", totalAmount);
        System.out.print('\n');
    }

    //Вывод накопленной суммы за каждый год и начисленные проценты
    public static void outputPerYearSum(float depositAmount, float interestRate, float termDeposit) {
        int[] eachYear = new int[(int) (termDeposit + 1)];
        for (int i = 1; i < eachYear.length; i++) {
            float amountInYear = depositAmount * (1 + interestRate);
            float temp = amountInYear - depositAmount;
            depositAmount = amountInYear;
            System.out.printf("%s год - %s, процент - %s", i, amountInYear, temp);
            System.out.print('\n');
        }
    }
}