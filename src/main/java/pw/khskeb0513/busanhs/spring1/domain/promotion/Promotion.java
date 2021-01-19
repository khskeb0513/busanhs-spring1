package pw.khskeb0513.busanhs.spring1.domain.promotion;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studenthistory")
@Getter
public class Promotion {

    @Id
    @Column(length = 13, name = "st_id")
    private String studentId;

    @Column(length = 5)
    private String class1;

    @Column(length = 30, name = "t_info1")
    private String tInfo1;

    @Column(length = 5)
    private String class2;

    @Column(length = 30, name = "t_info2")
    private String tInfo2;

    @Column(length = 5)
    private String class3;

    @Column(length = 30, name = "t_info3")
    private String tInfo3;

    @Column(length = 50, name = "bigo")
    private String memo;
}
