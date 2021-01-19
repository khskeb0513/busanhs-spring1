package pw.khskeb0513.busanhs.spring1.web;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pw.khskeb0513.busanhs.spring1.domain.student.State;
import pw.khskeb0513.busanhs.spring1.service.StudentService;

@Controller
@RequiredArgsConstructor
public class StudentController {

    final private StudentService studentService;
    final static String title = "Student";

    @GetMapping("/gui/student/findAll")
    public String findAll(Model model) {
        model.addAttribute("student_list", studentService.findAll())
                .addAttribute("title", title)
                .addAttribute("subtitle", "findAll");
        return "student/student_list";
    }

    @GetMapping("/gui/student/findByState")
    public String findByState(Model model, @Nullable @RequestParam String state) {
        if (state == null) {
            model.addAttribute("title", title)
                    .addAttribute("subtitle", "Input student type.");
            return "student/findByState/student_state_search";
        } else {
            model.addAttribute("title", title)
                    .addAttribute("subtitle", "Type " + State.inputStrToState(state).getKorStr())
                    .addAttribute("student_list", studentService.findByState(State.inputStrToState(state)));
            return "student/student_list";
        }
    }

    @GetMapping("/gui/student/findByName")
    public String findByName(Model model, @Nullable @RequestParam("name") String name) {
        if (name == null) {
            model.addAttribute("title", title)
                    .addAttribute("subtitle", "Input name.");
            return "student/findByName/student_name_search";
        } else {
            model.addAttribute("student_list", studentService.findByName(name))
                    .addAttribute("title", title)
                    .addAttribute("subtitle", "findByName: " + name);
            return "student/student_list";
        }
    }

    @GetMapping("/gui/student/findByGradeAndBan")
    public String findByGradeAndBan(Model model, @Nullable @RequestParam("grade") Integer grade, @Nullable @RequestParam("ban") Integer ban) {
        if (grade != null && ban != null) {
            model.addAttribute("student_list", studentService.findByGradeAndBan(grade, ban))
                    .addAttribute("title", title)
                    .addAttribute("subtitle", grade + "-" + ban);
            return "student/student_list";
        } else {
            model.addAttribute("title", title)
                    .addAttribute("subtitle", "Input grade and ban.");
            return "student/findByGradeAndBan/student_grade_and_ban_search";
        }
    }

    @GetMapping("/gui/student/findByStudentId")
    public String findByStudentId(Model model, @RequestParam("studentId") String studentId) {
        model.addAttribute("student", studentService.findByStudentId(studentId))
                .addAttribute("title", title)
                .addAttribute("subtitle", "findByStudentId");
        return "student/findByStudentId/student_info";
    }
}
