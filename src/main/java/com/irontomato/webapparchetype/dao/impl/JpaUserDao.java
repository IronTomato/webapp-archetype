package com.irontomato.webapparchetype.dao.impl;

import com.irontomato.webapparchetype.dao.UserDao;
import com.irontomato.webapparchetype.entity.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class JpaUserDao implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User getUser(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        em.merge(user);
    }
}
