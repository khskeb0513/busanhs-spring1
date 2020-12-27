package pw.khskeb0513.busanhs.spring1.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import pw.khskeb0513.busanhs.spring1.domain.student.Student;
import pw.khskeb0513.busanhs.spring1.domain.student.StudentRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class StudentApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void findAll() {
        final String url = "http://localhost:" + port + "/api/v1/student/findAll";
        List<Student> all = studentRepository.findAll();
        Student[] students = testRestTemplate.getForObject(url, Student[].class);
        List<Student> studentList = Arrays.asList(students);
        assertThat(studentList.get(0).getName()).isEqualTo(all.get(0).getName());
    }

    @Test
    public void findByName() {
        Student expectedStudent = studentRepository.findAll().get(0);
        final String url = "http://localhost:" + port + "/api/v1/student/name?name=" + expectedStudent.getName();
        Student[] students = testRestTemplate.getForObject(url, Student[].class);
        List<Student> studentList = Arrays.asList(students);
        assertThat(studentList.get(0).getName()).isEqualTo(expectedStudent.getName());
    }
}