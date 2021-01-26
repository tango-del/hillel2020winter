import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/myfirstdb";
    private static final String USER = "root";
    private static final String PASS = "Sobik2010";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/myfirstdb?useSSL=false&user=root&password=Sobik2010&serverTimezone=UTC");

//        Connection connection = DriverManager
//                .getConnection(URL, USER, PASS);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user where active = 1 and age > 18 and age <= 28 order by age, last_name");
//
//        System.out.println(resultSet.getMetaData().getTableName(1));
//
//        System.out.println("-------------------------");
//
//        int columnCount = resultSet.getMetaData().getColumnCount();
//
//        for (int i = 1; i <= columnCount; i++) {
//            System.out.print("column name : " + resultSet.getMetaData().getColumnName(i) + ", ");
//            System.out.print("column size : " + resultSet.getMetaData().getColumnDisplaySize(i) + ", ");
//            System.out.println("column type : " + resultSet.getMetaData().getColumnTypeName(i));
//        }
//
//        List<User> students = new ArrayList<>();
//
//        List<Map<String, String>> userMap = new ArrayList<>();
//
//        while (resultSet.next()) {
//           int id = resultSet.getInt("id");
////           String idS = resultSet.getString("id");
//           String last_name = resultSet.getString("last_name");
//           String first_name = resultSet.getString("first_name");
//           int age = resultSet.getInt("age");
//           String phone = resultSet.getString("phone");
//           String email = resultSet.getString("email");
//
//           Map<String, String> uMap = new HashMap<>();
//
//            for (int i = 1; i <= columnCount; i++) {
//                uMap.put(resultSet.getMetaData().getColumnName(i), resultSet.getString(resultSet.getMetaData().getColumnName(i)));
//
//            }
//            userMap.add(uMap);
//
//           students.add(new User(id, last_name, first_name, age, phone, email));
//        }
//
//        for (User st : students) {
//            System.out.println(st);
//        }
//
//        System.out.println(students.size());

//        PreparedStatement preparedStatement = connection.prepareStatement("insert into address(country, city) values (?, ?)");
//        List<String> cities = List.of("Berlin", "London", "Paris", "Madrid");
//        for (String city : cities) {
//            preparedStatement.setString(1, "Europe");
//            preparedStatement.setString(2, city);
//            preparedStatement.execute();
//        }

//        Statement st = connection.createStatement();
//        st.executeQuery("insert into address(country) value ('Spain')");

        connection.close();
    }
}
