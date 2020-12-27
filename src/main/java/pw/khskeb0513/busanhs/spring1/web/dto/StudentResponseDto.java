package pw.khskeb0513.busanhs.spring1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class StudentResponseDto {

    private String st_id;
    private String name;
    private int grade;
    private int ban;
    private int num;
    private String rf_card_num;
    private String state;
    private LocalDateTime out_date;
    private String st_memo;

    @Builder
    public StudentResponseDto(
            String st_id,
            String name,
            int grade,
            int ban,
            int num,
            String rf_card_num,
            String state,
            LocalDateTime out_date,
            String st_memo
    ) {
        this.st_id = st_id;
        this.name = name;
        this.grade = grade;
        this.ban = ban;
        this.num = num;
        this.rf_card_num = rf_card_num;
        this.state = state;
        this.out_date = out_date;
        this.st_memo = st_memo;
    }
}
