package com.metropolitan.it355dz08.controller;

import com.metropolitan.it355dz08.entity.Exam;
import com.metropolitan.it355dz08.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest-exam")
@RequiredArgsConstructor
public class ExamRestController {

    private final ExamService examService;

    @GetMapping()
    public ResponseEntity<List<Exam>> getAllExams() {
        return ResponseEntity.ok(examService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Exam> save(@RequestBody Exam exam) {
        return ResponseEntity.ok(examService.save(exam));
    }

    @PutMapping()
    public ResponseEntity<Exam> update(@RequestBody Exam exam) {
        return ResponseEntity.ok(examService.update(exam));
    }

    @DeleteMapping("/{examId}")
    public void deleteById(@PathVariable Integer examId) {
        List<Exam> examsList = examService.findAll();
        for (Exam exam : examsList) {
            if (exam.getId() == examId) {
                examService.delete(exam);
            }
        }
    }
}