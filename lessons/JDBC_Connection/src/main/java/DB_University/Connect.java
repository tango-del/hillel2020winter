package DB_University;

import Interfaces.Connection;

import java.sql.*;

/**
 * Класс создаёт соединение с базой данных с помощью jdbc драйвера.
 * @statement - используется для выполнения запросов SQL
 * @connection - соединение с базой данных
 * @resultSet - получает результат заданного запроса в базу данных
 * @preparedStatement - отправляет запрос в базу данных для её изменений
 */
public class Connect implements Connection {
    private final String URL;
    private final String USER;
    private final String PASS;
    static java.sql.Connection connection;

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
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USER, PASS);
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
