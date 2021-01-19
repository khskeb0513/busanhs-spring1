package pw.khskeb0513.busanhs.spring1.domain.attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, AttendancePK> {

    List<Attendance> findByStudentId(String studentId);

    @Query("select s from Attendance s where :startDate <= s.inDate and s.inDate <= :endDate order by s.inDate asc, s.inTime asc, s.state desc, s.grade asc")
    List<Attendance> findByInDate(LocalDateTime startDate, LocalDateTime endDate);

    @Query("select s from Attendance s where :startDate <= s.inDate and s.inDate <= :endDate and s.studentId = :studentId order by s.inDate asc, s.inTime asc, s.state desc, s.grade asc")
    List<Attendance> findByInDateAndStudentId(LocalDateTime startDate, LocalDateTime endDate, String studentId);

    @Query("select s from Attendance s where s.studentId in :studentIdList and :startDate <= s.inDate and s.inDate <= :endDate order by s.inDate asc, s.inTime asc, s.state desc, s.grade asc")
    List<Attendance> findByStudentIdListAndInDate(List<String> studentIdList, LocalDateTime startDate, LocalDateTime endDate);

}
