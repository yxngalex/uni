package ac.rs.metropolitan.it355dz06.repository;

import ac.rs.metropolitan.it355dz06.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
