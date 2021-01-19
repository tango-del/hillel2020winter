package hello;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    public static List<Student> list = StudentGenerator.studentList();

    @GetMapping("/ping")
    public String ping() {
        return "Hello";
    }

    @GetMapping("/hello")
    public String helloTest(@RequestParam String name) {
        System.out.println("run end point hello with param name -> " + name);
        if (name.equals("vasya")) throw new RuntimeException();
        return "hello " + name;
    }

    @GetMapping("/students")
    public List<Student> students() {
        return list;
    }

    @GetMapping("student/{id}")
    Student getStudent(@PathVariable UUID id) {
        return list.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    @PostMapping("student")
    boolean createNewStudent(@RequestBody StudentCreate studentCreate) {
        return list.add(new Student(UUID.randomUUID(), studentCreate.getFirstName(), studentCreate.getLastName()));
    }

    @PostMapping("students")
    boolean createNewStudents(@RequestBody List<StudentCreate> studentCreates) {
        studentCreates.forEach(s -> {
            list.add(new Student(UUID.randomUUID(), s.getFirstName(), s.getLastName()));
        });
        return true;
    }

    @DeleteMapping("student")
    void deleteStudent(@RequestParam String name) {
        list = list.stream().filter(student -> !student.getFirstName().equals(name)).collect(Collectors.toList());
    }

    @PutMapping("student/{id}")
    Student updateStudent(@PathVariable UUID id, @RequestParam(required = false) String fName, @RequestParam(required = false) String lName) {
        for (Student st : list) {
            if (st.getId().equals(id)) {
                st.setFirstName(fName);
                st.setLastName(lName);
                //if (Objects.nonNull(fName)) st.setFirstName(fName);
                //if (Objects.nonNull(lName)) st.setLastName(lName);
            } else {
                throw new RuntimeException();
            }
        }
        return null;
    }
}
