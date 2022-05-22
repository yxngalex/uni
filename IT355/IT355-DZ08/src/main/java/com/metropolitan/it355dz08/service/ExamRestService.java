package com.metropolitan.it355dz08.service;

import com.metropolitan.it355dz08.entity.Exam;

import java.util.List;

public interface ExamRestService {
    List<Exam> findAll();

    Exam save(Exam exam);

    Exam update(Exam exam);

    void delete(Integer examId);
}
