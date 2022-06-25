package ac.rs.metropolitan.it355dz06.controller;

import ac.rs.metropolitan.it355dz06.model.Exam;
import ac.rs.metropolitan.it355dz06.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ExamController {
    private final ExamService examService;

    @RequestMapping(value = "/exams", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("examList", examService.findAll());
        return "index";
    }

    @RequestMapping(value = "/save/{examId}", method = RequestMethod.POST)
    public String saveChanges(@PathVariable Integer examId, Model model) {
        Exam exam = examService.findById(examId);
        model.addAttribute("exam", exam);
        return "edit";
    }

}
