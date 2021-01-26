import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnEx {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        int i = 1;
        while (true) {
            System.out.println(i++);
            System.out.println();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb?useSSL=false&user=root&password=Sobik2010&serverTimezone=UTC");
        }
    }
}
