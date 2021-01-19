package pw.khskeb0513.busanhs.spring1.domain.teacher;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_num")
    private int keyNum;

    @Column(name = "t_id", length = 13)
    private String teacherId;

    @Column(name = "t_pass", length = 13)
    private String teacherPw;

    @Column(name = "t_name", length = 20)
    private String teacherName;

    @Column(name = "job_sel", length = 1)
    private String jobSelect;

    @Column(name = "t_class")
    private int grade;

    @Column(name = "t_ban")
    private int ban;

    @Column(length = 14)
    private String phone;

    @Column(name = "t_hp", length = 14)
    private String telephone;

    @Column(name = "t_memo", length = 100)
    private String teacherMemo;

    @Column(name = "job_state", length = 1)
    private String jobState;

    @Column(length = 1)
    private String special;

    @Column(name = "power_key", length = 30)
    private String powerKey;

    @Column(name = "t_subject", length = 30)
    private String teacherSubject;

    public Teacher(
            String teacherId,
            String teacherPw,
            String teacherName,
            String jobSelect,
            int grade,
            int ban,
            String phone,
            String telephone,
            String teacherMemo,
            String jobState,
            String special,
            String powerKey,
            String teacherSubject
    ) {
        this.teacherId = teacherId;
        this.teacherPw = teacherPw;
        this.teacherName = teacherName;
        this.jobSelect = jobSelect;
        this.grade = grade;
        this.ban = ban;
        this.phone = phone;
        this.telephone = telephone;
        this.teacherMemo = teacherMemo;
        this.jobState = jobState;
        this.special = special;
        this.powerKey = powerKey;
        this.teacherSubject = teacherSubject;
    }
}
