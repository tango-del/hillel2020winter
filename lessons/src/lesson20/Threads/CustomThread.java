package lesson20.Threads;

import lesson20.Main;
import lesson20.UserCard;

public class CustomThread extends Thread {
    UserCard userCard;

    public CustomThread(UserCard userCard) {
        this.userCard = userCard;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int tempAdd = Main.valueRandomizer();
            int tempRemove = Main.valueRandomizer();
            if (tempAdd % 2 == 0) {
                try {
                    userCard.addMoney(tempAdd);
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                   userCard.withdrawMoney(tempRemove);
                   sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName() + " thread end. Value -> " + userCard.getMoneyAmount());
    }
}
