package DB_University;

import Interfaces.SqlRequests;
import Tables.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @statement - используется для выполнения запросов SQL
 * @resultSet - получает результат заданного запроса в базу данных
 * @preparedStatement - отправляет запрос в базу данных для её изменений
 */
public class DatabaseRequests implements SqlRequests {
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

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
        preparedStatement = Connect.connection.prepareStatement("insert into students (full_name, `group`, year_join) values (?, ?, ?)");
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
        preparedStatement = Connect.connection.prepareStatement("delete from students where students_id = ?");
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
        statement = Connect.connection.createStatement();
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
}
