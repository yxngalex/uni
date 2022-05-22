package com.metropolitan.it355dz08.entity.dao.impl;
import com.metropolitan.it355dz08.entity.User;
import com.metropolitan.it355dz08.entity.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User add(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserByUsername(String username) {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username")
                .setParameter("username", username);
        return query.getSingleResult();
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