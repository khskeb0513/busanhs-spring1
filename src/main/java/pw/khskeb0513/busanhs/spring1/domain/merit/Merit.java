package pw.khskeb0513.busanhs.spring1.domain.merit;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Merit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "key_num")
    private int keyNum;

    @Column(nullable = false, name = "m_date")
    private LocalDateTime mDate;

    @Column(nullable = false, name = "m_time", length = 6)
    private String mTime;

    @Column(nullable = false, name = "st_id", length = 13)
    private String studentId;

    @Column(nullable = false, name = "merit_sel", length = 1)
    private String meritSel;

    @Column(nullable = false, name = "merit_code", length = 5)
    private String meritCode;

    @Column(nullable = false, name = "merit_text", columnDefinition = "TEXT")
    private String meritText;

    @Column(nullable = false, name = "merit_point")
    private int meritPoint;

    @Column(nullable = false, name = "t_id", length = 13)
    private String teacherId;

    @Column(length = 100)
    private String bigo;

    @Column(nullable = false, name = "work_date")
    private LocalDateTime workDate;

    @Column(nullable = false, name = "class")
    private int grade;

    @Builder
    public Merit(LocalDateTime mDate, String mTime, String studentId, String meritSel, String meritCode, String meritText, int meritPoint, String teacherId, String bigo, LocalDateTime workDate, int grade) {
        this.mDate = mDate;
        this.mTime = mTime;
        this.studentId = studentId;
        this.meritSel = meritSel;
        this.meritCode = meritCode;
        this.meritText = meritText;
        this.meritPoint = meritPoint;
        this.teacherId = teacherId;
        this.bigo = bigo;
        this.workDate = workDate;
        this.grade = grade;
    }

}
