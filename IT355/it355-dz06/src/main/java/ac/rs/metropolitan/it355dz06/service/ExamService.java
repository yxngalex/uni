package ac.rs.metropolitan.it355dz06.service;

import ac.rs.metropolitan.it355dz06.model.Exam;

import java.util.List;

public interface ExamService {

    List<Exam> findAll();

    Exam findById(Integer examId);

    Exam save(Exam exam);

    Exam update(Exam exam);

    void deleteById(Integer examId);

}
