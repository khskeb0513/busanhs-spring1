package pw.khskeb0513.busanhs.spring1.domain.attendance;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "studentin")
@Getter
@NoArgsConstructor
@IdClass(AttendancePK.class)
public class Attendance {

    //    PK
    @Id
    @NotNull
    private LocalDateTime inDate;

    @Id
    @NotNull
    private String inTime;

    @Id
    @NotNull
    @Column(length = 13, name = "st_id")
    private String studentId;

    @Id
    @NotNull
    @Column(length = 50, name = "gubun")
    private String type;

    @Column(name = "class")
    private int grade;

    @Column(length = 40, name = "bigo")
    private String memo;

    @Column(length = 2)
    private String state;

    @Column(length = 20, name = "STD_NAME")
    private String stdName;

    @Builder
    public Attendance(
            LocalDateTime inDate, String inTime, String studentId, int grade, String type, String memo, String state, String stdName
    ) {
        this.inDate = inDate;
        this.inTime = inTime;
        this.studentId = studentId;
        this.grade = grade;
        this.type = type;
        this.memo = memo;
        this.state = state;
        this.stdName = stdName;
    }
}
