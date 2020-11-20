package lesson4;

public class Main {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        final short distOdesToKryvOz = 179;
        final short distKryvOzToZhashk = 153;
        final short distZhashkToKyiv = 148;
        System.out.println("------------");
        System.out.println("Making route Odesa - Kyiv");
        Car car2 = new Car(60, 15);
        car2.fillFuel();

        System.out.println("------------");
        System.out.println("Route from Odesa to Kryve Ozero");
        car2.fuelCalc(distOdesToKryvOz);
        car2.fillFuel();

        System.out.println("------------");
        System.out.println("Route from Kryve Ozero to Zhashkiv");
        car2.fuelCalc(distKryvOzToZhashk);
        car2.fillFuel();

        System.out.println("------------");
        System.out.println("Route from Zhashkiv to Kyiv");
        car2.fuelCalc(distZhashkToKyiv);

        System.out.println("------------");
        double totalFuelCost = car2.spentFuel * 22;
        System.out.printf("Total distance: %s km. Total refuel: %s. Total fuel cost: %s grn. Remaining fuel: %s", car2.carMileage, car2.spentFuel, totalFuelCost, car2.fuelAmount);
        System.out.println();
    }
}
