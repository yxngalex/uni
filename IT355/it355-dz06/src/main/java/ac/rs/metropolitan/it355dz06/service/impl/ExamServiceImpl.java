package ac.rs.metropolitan.it355dz06.service.impl;

import ac.rs.metropolitan.it355dz06.model.Exam;
import ac.rs.metropolitan.it355dz06.repository.ExamRepository;
import ac.rs.metropolitan.it355dz06.service.ExamService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {
    private final ExamRepository examRepository;

    @Override
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    @Override
    public Exam findById(Integer examId) {
        return examRepository.findById(examId)
                .orElseThrow(() -> new NoSuchElementException("ExamService.notFound"));
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
    public void deleteById(Integer examId) {
        examRepository.deleteById(examId);
    }
}
