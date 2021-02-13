import java.text.NumberFormat;
import java.util.Locale;

public class Money {
    public static void main(String[] args) {
        NumberFormat dollar = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat euro = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        NumberFormat grn = NumberFormat.getCurrencyInstance(new Locale("ru", "UA"));

        int amount = 12_355;

        System.out.println(dollar.format(amount));
        System.out.println(euro.format(amount));
        System.out.println(grn.format(amount));
    }
}
