package com.metropolitan.it355dz08.service.impl;

import com.metropolitan.it355dz08.entity.Exam;
import com.metropolitan.it355dz08.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {


    private SessionFactory sessionFactory;

    @Autowired
    public ExamServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Exam> findAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Exam> query = sessionFactory.getCurrentSession().createQuery("from Exam");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Exam save(Exam exam) {
        sessionFactory.getCurrentSession().saveOrUpdate(exam);
        return exam;
    }

    @Override
    @Transactional
    public Exam update(Exam exam) {
        sessionFactory.getCurrentSession().saveOrUpdate(exam);
        return exam;
    }

    @Override
    @Transactional
    public void delete(Exam exam) {
        sessionFactory.getCurrentSession().delete(exam);
    }
}