package pw.khskeb0513.busanhs.spring1.domain.attendance;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class AttendancePK implements Serializable {

    private LocalDateTime inDate;
    private String inTime;
    private String studentId;
    private String type;
}
