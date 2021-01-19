package pw.khskeb0513.busanhs.spring1.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByName(String name);

    List<Student> findByStateOrderByOutDateDesc(String state);

    List<Student> findByGradeAndBanAndStateOrderByGradeAscBanAscNumAsc(int grade, int ban, String state);

    List<Student> findByStudentId(String studentId);
}
