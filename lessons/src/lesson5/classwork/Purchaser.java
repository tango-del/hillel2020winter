package lesson5.classwork;

public class Purchaser extends Staff {
    private String inventoryControl; //склад учет
    private boolean healthBook; //санитар книга
    private Auto auto = new Auto();

    public void interactWithKitchen() {

    }

    public void purchaseProducts(int money) {
        money -= money;
    }

    public void deliverProductsToRestourant() {

    }
}
