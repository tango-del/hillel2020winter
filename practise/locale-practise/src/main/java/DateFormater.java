import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class DateFormater {
    public static void main(String[] args) {
        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.atZone(ZoneId.of("US/Pacific")));

        print("de");
        print("en");
        print("us");
        print("ru");
    }

    public static void print(String loc) {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, new Locale(loc));
        System.out.println(df.format(new Date()));
    }
}
