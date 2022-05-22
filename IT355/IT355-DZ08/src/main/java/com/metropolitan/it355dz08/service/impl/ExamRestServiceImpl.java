package com.metropolitan.it355dz08.service.impl;

import com.metropolitan.it355dz08.entity.Exam;
import com.metropolitan.it355dz08.repository.ExamRepository;
import com.metropolitan.it355dz08.service.ExamRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamRestServiceImpl implements ExamRestService {
    private final ExamRepository examRepository;

    @Override
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    @Override
    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Exam update(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public void delete(Integer examId) {
        examRepository.deleteById(examId);
    }
}
