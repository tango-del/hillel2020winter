import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String str = "BEVERAGE";
        String[] arr = str.split("E", 3);
        System.out.println(Arrays.toString(arr));
        System.out.println(String.join(".", arr));
    }
}
