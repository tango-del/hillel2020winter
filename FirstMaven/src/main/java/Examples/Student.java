package Examples;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
//@Builder
@ToString
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String age;
    private String sex;
    private String pasportData;

    public String getFullName () {
        return firstName + " " + lastName;}
}

