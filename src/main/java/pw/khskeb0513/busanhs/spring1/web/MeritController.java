package pw.khskeb0513.busanhs.spring1.web;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pw.khskeb0513.busanhs.spring1.domain.merit.Merit;
import pw.khskeb0513.busanhs.spring1.domain.student.Student;
import pw.khskeb0513.busanhs.spring1.service.CommonService;
import pw.khskeb0513.busanhs.spring1.service.MeritService;
import pw.khskeb0513.busanhs.spring1.service.StudentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MeritController {

    private final MeritService meritService;
    private final StudentService studentService;
    private final CommonService commonService;
    private final String title = "Point";

    @GetMapping("/gui/point/findByStudentName")
    public String findByStudentName(Model model, @RequestParam @Nullable String name, @RequestParam @Nullable String studentId) {
        model.addAttribute("title", title)
                .addAttribute("subtitle", "findByStudentName");
        if (studentId != null) {
            Student student = studentService.findByStudentId(studentId);
            model.addAttribute("merit_list", meritService.findByStudentName(student))
                    .addAttribute("subtitle", "findByStudentName: " + student.getName() + "(" + student.getStudentId() + ")");
            return "merit/findByStudentName/merit_list";
        } else {
            if (name == null) {
                return "merit/findByStudentName/search_by_student_name";
            } else {
                model.addAttribute("student_list", studentService.findByName(name));
                return "merit/findByStudentName/student_list_by_name_search";
            }
        }
    }

    @GetMapping("/gui/point/findByPointRangeAndDateRange")
    public String findByPointRangeAndDateRange(
            Model model, @RequestParam @Nullable String dateStart, @RequestParam @Nullable String dateEnd
    ) {
        model.addAttribute("title", title)
                .addAttribute("subtitle", "findByPointRangeAndDateRange");
        if (dateStart != null && dateEnd != null) {
            List<Merit> meritList = meritService.findByMDateBetween(
                    commonService.stringToLocalDateTime(dateStart),
                    commonService.stringToLocalDateTime(dateEnd)
            );
            model.addAttribute("merit_list", meritService.groupByStudentId(meritList));
            return "merit/findByDateRange/merit_list";
        } else {
            return "merit/findByDateRange/search";
        }
    }
}
