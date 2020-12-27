package pw.khskeb0513.busanhs.spring1.web;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pw.khskeb0513.busanhs.spring1.service.StudentService;

@Controller
@RequestMapping("/student/*")
@RequiredArgsConstructor
public class StudentController {

    final private StudentService studentService;
    final static String title = "Student";

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("student_list", studentService.findAll())
                .addAttribute("title", title)
                .addAttribute("subtitle", "findAll");
        return "student/student_list";
    }

    @GetMapping("/findByState")
    public String findByState(Model model, @Nullable @RequestParam String state) {
        if (state == null) {
            model.addAttribute("title", title)
                    .addAttribute("subtitle", "input student type.");
            return "student/student_state_search";
        } else {
            String korState = "";
            state = state.toUpperCase();
            switch (state) {
                case "A":
                    korState = "재학";
                    break;
                case "B":
                    korState = "자퇴";
                    break;
                case "C":
                    korState = "전출";
                    break;
            }
            model.addAttribute("title", title)
                    .addAttribute("subtitle", "Type " + korState)
                    .addAttribute("student_list", studentService.findByState(state));
            return "student/student_list";
        }
    }

    @GetMapping("/findByName")
    public String findByName(Model model, @Nullable @RequestParam("name") String name) {
        if (name == null) {
            model.addAttribute("title", title)
                    .addAttribute("subtitle", "input name.");
            return "student/student_name_search";
        } else {
            model.addAttribute("student_list", studentService.findByName(name))
                    .addAttribute("title", title)
                    .addAttribute("subtitle", name);
            return "student/student_list";
        }
    }

    @GetMapping("/findByGradeAndBan")
    public String findByGradeAndBan(Model model, @Nullable @RequestParam("grade") Integer grade, @Nullable @RequestParam("ban") Integer ban) {
        if (grade != null && ban != null) {
            model.addAttribute("student_list", studentService.findByGradeAndBan(grade, ban))
                    .addAttribute("title", title)
                    .addAttribute("subtitle", grade + "-" + ban);
            return "student/student_list";
        } else {
            model.addAttribute("title", title)
                    .addAttribute("subtitle", "input grade and ban.");
            return "student/student_grade_and_ban_search";
        }
    }
}
