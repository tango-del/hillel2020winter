import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    private int index;
    private String name;
    private String surname;
    private String fullname;
    private int age;
    private String email;
    private Boolean active;
}
