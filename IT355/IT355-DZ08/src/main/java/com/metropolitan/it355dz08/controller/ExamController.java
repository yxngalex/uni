package com.metropolitan.it355dz08.controller;

import com.metropolitan.it355dz08.entity.Exam;
import com.metropolitan.it355dz08.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @GetMapping("/exam")
    public String getAllExams(Model model) {
        model.addAttribute("getExams", examService.findAll());
        return "index";
    }

    @GetMapping("/showNewExamForm")
    public String showNewExamForm(Model model) {
        Exam exam = new Exam();
        model.addAttribute("exam", exam);
        return "add_exam";
    }

    @PostMapping(value = "/deleteExam/{id}")
    public String deleteExam(@PathVariable Integer id) {
        List<Exam> examsList = examService.findAll();
        for (Exam exam : examsList) {
            if (exam.getId() == id) {
                examService.delete(exam);
            }
        }
        return "redirect:/";
    }

    @PostMapping("/saveExam")
    public String saveEmployee(@ModelAttribute("exam") Exam exam) {
        examService.update(exam);
        return "redirect:/";
    }

    @GetMapping("/showEditExamForm/{id}")
    public String showEditEmployeeForm(@PathVariable Integer id, Model model) {
        List<Exam> examsList = examService.findAll();

        for (Exam exam : examsList) {
            if (exam.getId().equals(id)) {
                model.addAttribute("exam", exam);
            }
        }
        return "edit_exam";
    }

}
