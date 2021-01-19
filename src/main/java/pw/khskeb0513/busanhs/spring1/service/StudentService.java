package pw.khskeb0513.busanhs.spring1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pw.khskeb0513.busanhs.spring1.domain.student.State;
import pw.khskeb0513.busanhs.spring1.domain.student.Student;
import pw.khskeb0513.busanhs.spring1.domain.student.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        Sort sort = Sort.by(
                Sort.Order.asc("grade"),
                Sort.Order.asc("ban"),
                Sort.Order.asc("num")
        );
        return studentRepository.findAll(sort);
    }

    @Transactional(readOnly = true)
    public List<Student> findByState(State state) {
        return studentRepository.findByStateOrderByOutDateDesc(state.getDbStr());
    }

    @Transactional(readOnly = true)
    public List<Student> findByGradeAndBan(int grade, int ban) {
        return studentRepository.findByGradeAndBanAndStateOrderByGradeAscBanAscNumAsc(grade, ban, "Y");
    }

    @Transactional(readOnly = true)
    public Student findByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId).get(0);
    }
}
