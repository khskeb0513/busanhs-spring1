package pw.khskeb0513.busanhs.spring1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pw.khskeb0513.busanhs.spring1.domain.attendance.Attendance;
import pw.khskeb0513.busanhs.spring1.domain.attendance.AttendanceRepository;
import pw.khskeb0513.busanhs.spring1.domain.student.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public List<Attendance> findByStudentId(String studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

    public List<Attendance> findByInDate(LocalDateTime startDate, LocalDateTime endDate) {
        return attendanceRepository.findByInDate(startDate, endDate);
    }

    public List<Attendance> findByInDateAndStudentId(
            LocalDateTime startDate, LocalDateTime endDate, String studentId
    ) {
        return attendanceRepository.findByInDateAndStudentId(startDate, endDate, studentId);
    }

    public List<Attendance> findByStudentListAndInDate(
            List<Student> studentList, LocalDateTime startDate, LocalDateTime endDate
    ) {
        List<String> studentIdList = new ArrayList<>();
        studentList.forEach(v -> studentIdList.add(v.getStudentId()));
        return attendanceRepository.findByStudentIdListAndInDate(studentIdList, startDate, endDate);
    }
}
