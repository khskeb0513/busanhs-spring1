package pw.khskeb0513.busanhs.spring1.domain.student;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Student {

    @Id
    @Column(length = 13, nullable = false, name = "st_id")
    private String studentId;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(name = "class", nullable = false)
    private int grade;

    @Column(nullable = false)
    private int ban;

    @Column(nullable = false)
    private int num;

    @Column(length = 30, nullable = false)
    private String subject;

    @Column(length = 20, nullable = false)
    private String rf_card_num;

    @Column(length = 1, nullable = false)
    private String state;

    @Column(columnDefinition = "DATETIME", name = "out_date")
    private LocalDateTime outDate;

    @Column(length = 100)
    private String st_memo;

    @Column(length = 1)
    private String st_lock;

    @Column(length = 14)
    private String jumin;

    @Column(length = 16)
    private String barcode_num;
}
