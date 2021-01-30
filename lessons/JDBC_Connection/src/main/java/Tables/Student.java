package Tables;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.SQLException;

/**
 * Записывает в себя сущности таблицы Students базы данных University.
 * Конструктор принимает объект Builder
 * Построен на базе паттерна Builder, даёт возможность строить каждый экземпляр класса внося любое колличество данных.
 * Переопределённый ToString возвращает поля @students_id и @fullName
 */
@Getter
@Setter
@NoArgsConstructor
public class Student {
    private int students_id;
    private String fullName;
    private int group;
    private int yearJoin;

    private Student(Builder builder) {
        this.fullName = builder.fullName;
        this.group = builder.group;
        this.yearJoin = builder.yearJoin;
        this.students_id = builder.students_id;
    }

    @Override
    public String toString() {
        return "|ID: " + students_id + " | name:  " + fullName;
    }

    /**
     * Класс вызывается у класса Student, сохраняет указанные значения.
     * build() вызывает конструктор Student
     */
    public static class Builder {
        private int students_id;
        private String fullName;
        private int group;
        private int yearJoin;

        public Builder setStudentsId(int id) {
            this.students_id = id;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setGroup(int group) throws SQLException {
            if (group < 1 || group > 12) {
                throw new SQLException("incorrect group id");
            }
            this.group = group;
            return this;
        }

        public Builder setYearJoin(int yearJoin) {
            this.yearJoin = yearJoin;
            return this;
        }

        public Student build() throws SQLException {
            if (group == 0 || yearJoin == 0 || fullName == null) {
                throw new SQLException("incorrect group id");
            }
            return new Student(this);
        }
    }
}
