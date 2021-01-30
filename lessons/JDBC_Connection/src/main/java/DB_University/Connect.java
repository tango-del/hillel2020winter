package DB_University;

import Interfaces.SqlWork;
import Tables.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс создаёт соединение с базой данных с помощью jdbc драйвера.
 * @statement - используется для выполнения запросов SQL
 * @connection - соединение с базой данных
 * @resultSet - получает результат заданного запроса в базу данных
 * @preparedStatement - отправляет запрос в базу данных для её изменений
 */
public class Connect implements SqlWork {
    private final String URL;
    private final String USER;
    private final String PASS;
    private Statement statement;
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    /**
     * Стандартный констроктор класса
     * @param URL - сервер базы данных
     * @param USER - логин пользовотеля
     * @param PASS - пароль пользователя
     */
    public Connect(String URL, String USER, String PASS) {
        this.URL = URL;
        this.USER = USER;
        this.PASS = PASS;
    }

    /**
     * Метод использует класс драйвера jdbc и создаёт соединение по указанному серверу, под указанным пользователем и паролем
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public void createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USER, PASS);
    }

    /**
     * Метод добавляет новую сущность в таблицу Students
     * Создаётся запрос SQL в котором заполняются значения full_name, group, year_join , которые вызываются у объекта student.
     * @execute() - отправляет сгенерированный запрос в базу данных
     *
     * @param student - объект в котором хранятся данные, которые будут отправлены в запросе SQL
     * @throws SQLException
     */
    @Override
    public void addNewRowStudent(Student student) throws SQLException {
        preparedStatement = connection.prepareStatement("insert into students (full_name, `group`, year_join) values (?, ?, ?)");
        preparedStatement.setString(1, student.getFullName());
        preparedStatement.setInt(2, student.getGroup());
        preparedStatement.setInt(3, student.getYearJoin());
        preparedStatement.execute();
    }

    /**
     * Метод удаляет сущность в таблице Students по указанному id.
     * Создаётся запрос SQL в котором заполняется значение.
     * @execute() - отправляет сгенерированный запрос в базу данных, если такой id есть тогда сущность под этим номером будет удалена с таблицы.
     *
     * @param students_id - хранит в себе цифру id которого нужно удалить с таблицы Students
     * @throws SQLException
     */
    @Override
    public void deleteRawStudentByID(int students_id) throws SQLException {
            preparedStatement = connection.prepareStatement("delete from students where students_id = ?");
            preparedStatement.setInt(1, students_id);
            preparedStatement.execute();
    }

    /**
     * Метод выводит на экран все сущности таблицы Students в виде students_id и full_name.
     * @resultSet - отправляет запрос на сервер и сохраняет в себе полученный ответ от сервера.
     * Создаётся List<Student> @students который запишет в себя данные каждой сущности в таблице.
     * С помощью итератора @resultSet.next() проходится по каждой сущности которую получил от сервера,
     * и добавляет указанные значения в список @students, каждый элемент массива является обхект Student.
     * Итератор forEach проходит по всему списку List<Student> @students и выводит каждого в консоль.
     *
     * @throws SQLException
     */
    @Override
    public void outputAllStudentsIdAndName() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from students");
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("students_id");
            String fullName = resultSet.getString("full_name");
            int group = resultSet.getInt("group");
            int yearJoin = resultSet.getInt("year_join");
            students.add(new Student.Builder().setStudentsId(id).setGroup(group).setYearJoin(yearJoin).setFullName(fullName).build());
        }
        students.forEach(System.out::println);
    }

    /**
     * Метод закрывает соединение с сервером базы данных
     *
     * @throws SQLException
     */
    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
