package com.metropolitan.it355dz08.service.dao;

import com.metropolitan.it355dz08.entity.Exam;

import java.util.List;

public interface ExamDao {
    List<Exam> findAll();

    Exam save(Exam exam);

    Exam update(Exam exam);

    void delete(Exam exam);
}
