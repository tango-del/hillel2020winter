package ObjectSize;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Person {
    private String name;
    private String city;
//    private String _city;
//    private String __city;
    private List<Course> courses = new ArrayList<>();
    private int level;
    private double salary;
    private char grade;
//    private char _grade;
    private boolean active;
//    private boolean _active;
}
