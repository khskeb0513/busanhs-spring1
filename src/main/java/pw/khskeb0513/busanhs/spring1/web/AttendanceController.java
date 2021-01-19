package pw.khskeb0513.busanhs.spring1.web;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pw.khskeb0513.busanhs.spring1.service.AttendanceService;
import pw.khskeb0513.busanhs.spring1.service.CommonService;
import pw.khskeb0513.busanhs.spring1.service.StudentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final StudentService studentService;
    private final CommonService commonService;
    private final String title = "Attendance";

    @GetMapping("/gui/attendance/findByName")
    public String findByName(
            Model model, @RequestParam @Nullable String name, @RequestParam @Nullable String studentId
    ) {
        model.addAttribute("title", title)
                .addAttribute("subtitle", "findByName");
        if (studentId != null) {
            model.addAttribute("attendance_list", attendanceService.findByStudentId(studentId));
            return "attendance/attendance_list";
        } else {
            if (name != null) {
                model.addAttribute("student_list", studentService.findByName(name));
                return "attendance/findByName/student_list_by_name_search";
            } else {
                return "attendance/findByName/student_name_search";
            }
        }
    }

    @GetMapping("/gui/attendance/findByDateAndStudentId")
    public String findByDateAndStudentId(
            Model model, @RequestParam @Nullable String startDate, @RequestParam @Nullable String endDate, @RequestParam @Nullable String studentId
    ) {
        model.addAttribute("title", title);
        if (studentId == null) studentId = "";
        if (startDate != null && endDate != null && !studentId.equals("")) {
            model.addAttribute("attendance_list", attendanceService.findByInDateAndStudentId(
                    commonService.stringToLocalDateTime(startDate),
                    commonService.stringToLocalDateTime(endDate),
                    studentId
            )).addAttribute("subtitle", "findByDateAndStudentId");
            return "attendance/attendance_list";
        } else {
            if (startDate != null && endDate != null) {
                model.addAttribute("attendance_list", attendanceService.findByInDate(
                        commonService.stringToLocalDateTime(startDate),
                        commonService.stringToLocalDateTime(endDate)
                )).addAttribute("subtitle", "findByDate");
                return "attendance/attendance_list";
            } else {
                return "attendance/findByDateAndStudentId/search_by_date_and_studentId";
            }
        }
    }

    @GetMapping("/gui/attendance/findByGradeAndBanAndDate")
    public String findByGradeAndBanAndDate(
            Model model,
            @RequestParam @Nullable Integer grade,
            @RequestParam @Nullable Integer ban,
            @RequestParam @Nullable String startDate,
            @RequestParam @Nullable String endDate
    ) {
        if (startDate == null) startDate = "";
        if (endDate == null) endDate = "";
        model.addAttribute("title", title);
        if (grade != null && ban != null && !startDate.equals("") && !endDate.equals("")) {
            model
                    .addAttribute(
                            "subtitle",
                            grade + "-" + ban + " " + startDate + " ~ " + endDate
                    )
                    .addAttribute(
                            "attendance_list",
                            attendanceService.findByStudentListAndInDate(
                                    studentService.findByGradeAndBan(grade, ban),
                                    commonService.stringToLocalDateTime(startDate),
                                    commonService.stringToLocalDateTime(endDate)
                            ));
            return "attendance/attendance_list";
        } else {
            if (grade != null && ban != null) {
                LocalDateTime dateTime = LocalDate.now().atStartOfDay();
                model
                        .addAttribute(
                                "subtitle",
                                grade + "-" + ban + " " + dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        )
                        .addAttribute(
                                "attendance_list",
                                attendanceService.findByStudentListAndInDate(
                                        studentService.findByGradeAndBan(grade, ban),
                                        dateTime,
                                        dateTime
                                ));
                return "attendance/attendance_list";
            } else {
                return "attendance/findByGradeAndBanAndDate/search_by_grade_and_ban_and_date";
            }
        }
    }
}
