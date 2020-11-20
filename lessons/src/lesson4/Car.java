package lesson4;

public class Car {
    int amountTank; //объем бака
    int fuelAmount; //остаток в баке
    double fuelConsumption; //расход топлива на 100 км
    double carMileage;
    double spentFuel;

    public Car(int amountTank, double fuelConsumption) {
        this.amountTank = amountTank;
        this.fuelConsumption = fuelConsumption;
    }

    //залить полный бак с учетом объема остатка
    public void fillFuel() {
        System.out.println("Current fuel amount: " + fuelAmount);
        fuelAmount = fuelAmount + (amountTank - fuelAmount);
        System.out.printf("Refill fuel amount: %s", fuelAmount);
        System.out.println();
    }

    public void quantityMileage(final double quantity, double spentFuel) {
        carMileage += quantity;
        this.spentFuel += spentFuel;
    }

    //определить остаток топлива по преодолении N км
    public void fuelCalc(final int kilometres) {
        double spentFuel = kilometres * fuelConsumption / 100;
        fuelAmount -= spentFuel;
        System.out.printf("Fuel remaining after overcoming %s km: %s", kilometres, fuelAmount);
        System.out.println();
        calcReFillFuel(kilometres);
        quantityMileage(kilometres, spentFuel);
    }

    //определить сколько надо до заправить топлива при преодолении N км
    public void calcReFillFuel(final int kilometres) {
//        double currentPossibleDistance = fuelAmount * 100 / fuelConsumption;
//        double kilometresLeft = currentPossibleDistance - kilometres;
//        double remainFuel = kilometresLeft * fuelConsumption / 100;
//        System.out.printf("You need refill %.2f fuel", remainFuel);
//        System.out.println();
        double spentFuel = kilometres * fuelConsumption / 100;
        System.out.printf("You need refill %.2f fuel", spentFuel);
        System.out.println();
    }
}
