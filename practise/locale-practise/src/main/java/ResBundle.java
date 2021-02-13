import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResBundle {
    public static void main(String[] args) throws InterruptedException {
        List<Locale> localeList = List.of(new Locale("de"),
                new Locale("ru"),
                new Locale("ua"),
                new Locale("fr"),
                new Locale("us"));

//        Locale.setDefault(Locale.CHINA);
//
//        ResourceBundle resourceBundle =
//                ResourceBundle.getBundle("Day",
//                        new Locale("ru"));
//        System.out.println(resourceBundle.getString("day1"));
//        System.out.println(resourceBundle.getString("day2"));



        while (true) {
            Locale locale = localeList.get((int) (Math.random() * 5));
            ResourceBundle resourceBundle = ResourceBundle.getBundle("MessagesBundle", locale);

            System.out.print("Lang: " + locale.getLanguage() + " >>> ");
            System.out.println(resourceBundle.getString("hello"));
            Thread.sleep(2000);
        }
    }
}
