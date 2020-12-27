package pw.khskeb0513.busanhs.spring1.domain.merit;

import org.springframework.data.jpa.repository.JpaRepository;
import pw.khskeb0513.busanhs.spring1.domain.student.Student;

public interface MeritRepository extends JpaRepository<Student, Integer> {
}
