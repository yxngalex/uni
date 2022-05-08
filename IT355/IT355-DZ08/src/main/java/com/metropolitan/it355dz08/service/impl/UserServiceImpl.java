package com.metropolitan.it355dz08.service.impl;

import com.metropolitan.it355dz08.entity.User;
import com.metropolitan.it355dz08.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private SessionFactory sessionFactory;

    @Autowired
    public UserServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> q = sessionFactory.getCurrentSession().createQuery("from User");
        System.out.println(q);
        return q.getResultList();
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }
}
