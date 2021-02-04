import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            init();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void init() throws IOException, ClassNotFoundException, SQLException {
        Properties prop = new Properties();
        String propFile = "MYSQL_Connect.properties";
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(propFile);

        prop.load(inputStream);
        inputStream.close();

        String driver = prop.getProperty("driver");
        String server = prop.getProperty("server");
        String user = prop.getProperty("user");
        String pass = prop.getProperty("pass");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(server, user, pass);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from orders");

        System.out.println(resultSet.getMetaData().getColumnCount());

        while (resultSet.next()) {
            System.out.println(resultSet.getMetaData().getTableName(1));
        }


    }
}
