import java.text.DateFormat;
import java.util.Locale;

public class SystemLocale {
    public static void main(String[] args) {
        Locale[] supportedLocales = DateFormat.getAvailableLocales();

        Locale current = Locale.getDefault();

        System.out.println(current.getCountry());
        System.out.println(current.getLanguage());

        Locale.setDefault(Locale.KOREAN);

        System.out.println(current.getCountry());
        System.out.println(current.getLanguage());

        for (Locale locale : supportedLocales){
            System.out.println(locale.getDisplayName());
        }
    }
}
