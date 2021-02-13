package InternetShop;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class TovarRun {

    private static Tovar tovar = new Tovar("name", "size", "color", 100);

    public static void main(String[] args) {
        Locale locale;
       if (args.length == 0) {
           locale = new Locale("ru", "RU");
       } else {
           locale = new Locale(args[0], args[1]);
       }

        ResourceBundle resourceBundle = ResourceBundle.getBundle("tovar", locale);
        System.out.println(resourceBundle.getString(tovar.getName()));
        System.out.println(resourceBundle.getString(tovar.getSize()));
        System.out.println(resourceBundle.getString(tovar.getColor()));
        NumberFormat currFmt = NumberFormat.getCurrencyInstance(locale);
        if (locale.getCountry().equals("DE")) {
            tovar.setPrice(tovar.getPrice() * 0.9);
        }
        System.out.println(currFmt.format(tovar.getPrice()));
    }
}
