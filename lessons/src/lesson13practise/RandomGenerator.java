package lesson13practise;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {

    public static int getIntValue(int maxValue) {
        return (int) (Math.random()*maxValue);
    }

    public static String getStringValue(int numberOfChar) {
        return RandomStringUtils.randomAlphabetic(numberOfChar);
    }

    public static void main(String[] args) {
        System.out.println(getIntValue(100));

        System.out.println(getStringValue(10));
    }
}