package lesson20;

public class UserCard {
    private static UserCard instance;

    private String userName;

    private int moneyAmount = 250;

    public synchronized void addMoney(int amount) {
        moneyAmount += amount;
        System.out.println(Thread.currentThread().getName() + " -> Money added -> " + amount + " Current value -> " + moneyAmount);
    }

    public synchronized void withdrawMoney(int amount) {
        if (amount < moneyAmount) {
            System.out.println(Thread.currentThread().getName() + " -> Before withdraw -> " + moneyAmount);
            moneyAmount -= amount;
            System.out.println(Thread.currentThread().getName() + " -> After withdraw -> " + moneyAmount + " -> Amount of money withdrawn: " + amount);

        } else {
            System.out.println(Thread.currentThread().getName() + " -> Not enough money in card. Current value -> " + moneyAmount + "You trying withdraw: " + amount);
        }
    }

    public synchronized int getMoneyAmount() {
        return moneyAmount;
    }

    public  static UserCard getInstance(String name) {
        if (instance == null) {
            instance = new UserCard(name);
        }
        return instance;
    }

    private UserCard(String user) {
        userName = user;
    }
}
