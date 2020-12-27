package pw.khskeb0513.busanhs.spring1.web;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pw.khskeb0513.busanhs.spring1.domain.student.Student;
import pw.khskeb0513.busanhs.spring1.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentApiController {

    private final StudentService studentService;

    @GetMapping("/api/v1/student/name")
    public List<Student> findByName(
            @RequestParam("name") String name
    ) {
        return studentService.findByName(name);
    }

    @GetMapping("/api/v1/student/findAll")
    public List<Student> findAll(
            @Nullable @RequestParam("state") String state
    ) {
        return state == null ? studentService.findAll() : studentService.findByState(state);
    }
}