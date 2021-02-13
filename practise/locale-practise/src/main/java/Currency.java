import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class Currency {
    public static void main(String[] args) {
        Locale loc = Locale.US;

        NumberFormat currFmt = NumberFormat.getCurrencyInstance(loc);
        currFmt.setCurrency(java.util.Currency.getInstance("EUR"));
        BigDecimal amt = BigDecimal.valueOf(12345.68504d).setScale(2, RoundingMode.HALF_DOWN);
        System.out.println(amt);
        System.out.println(currFmt.format(amt));
    }
}
