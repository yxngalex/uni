package com.metropolitan.it355dz08.repository;

import com.metropolitan.it355dz08.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
