package lesson4;
/*
в классе Мейн надо определить и вывести на экран сколько надо долить топлива
и его стоимость если маршрут у нас Одесса - Киев

+ 2 обязательные остановки для дозаправки Кривое Озеро и Жашков

+ сколько будет стоить полная поездка

+ остаток топлива в пункте назначения
одесса киев 479км
одесса кривое озеро 179км
кривое озеро - жавшком 153км
жашков - киев 148км
за 1л - 21грн
 */

public class Main {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        //        Car car1 = new Car(60, 14);
//        car1.fuelAmount = 20;
//        car1.fillFuel();
//        car1.fuelCalc(70);
//        car1.calcReFillFuel(1000);
        System.out.println("------------");
        System.out.println("Making route Odesa - Kyiv");
        Car car2 = new Car(60, 15);
        car2.fillFuel();

        System.out.println("------------");
        System.out.println("Route from Odesa to Kryve Ozero");
        car2.fuelCalc(179);
        car2.fillFuel();

        System.out.println("------------");
        System.out.println("Route from Kryve Ozero to Zhashkiv");
        car2.fuelCalc(153);
        car2.fillFuel();

        System.out.println("------------");
        System.out.println("Route from Zhashkiv to Kyiv");
        car2.fuelCalc(148);

        System.out.println("------------");
        double totalFuelCost = car2.spentFuel * 22;
        System.out.printf("Total distance: %s km. Total refuel: %s. Total fuel cost: %s grn", car2.carMileage, car2.spentFuel, totalFuelCost);
        System.out.println();
    }
}
