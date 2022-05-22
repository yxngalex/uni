package com.metropolitan.it355dz08.service.impl;

import com.metropolitan.it355dz08.entity.Exam;
import com.metropolitan.it355dz08.entity.dao.ExamDao;
import com.metropolitan.it355dz08.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamDao examDao;

    public ExamServiceImpl(ExamDao examDao) {
        this.examDao = examDao;
    }

    @Transactional
    @Override
    public List<Exam> findAll() {
        return examDao.findAll();
    }

    @Transactional
    @Override
    public Exam save(Exam exam) {
        return examDao.save(exam);
    }

    @Transactional
    @Override
    public Exam update(Exam exam) {
        return examDao.update(exam);
    }

    @Transactional
    @Override
    public void delete(Exam exam) {

    }
}