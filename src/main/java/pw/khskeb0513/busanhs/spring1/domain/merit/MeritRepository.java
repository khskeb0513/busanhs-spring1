package pw.khskeb0513.busanhs.spring1.domain.merit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MeritRepository extends JpaRepository<Merit, Integer> {

    List<Merit> findByStudentId(String studentId);

    @Query("select s from Merit s where :startDate <= s.mDate and s.mDate <= :endDate")
    List<Merit> findByMDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
