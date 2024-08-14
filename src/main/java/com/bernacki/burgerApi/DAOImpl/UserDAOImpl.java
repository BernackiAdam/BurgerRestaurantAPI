package com.bernacki.burgerApi.DAOImpl;

import com.bernacki.burgerApi.DAO.UserDAO;
import com.bernacki.burgerApi.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByUserName(String username) {
        TypedQuery<User> query = entityManager.createQuery(
                "FROM User WHERE userName=:uName", User.class
        );
        query.setParameter("uName", username);
        User user = null;
        try{
            user = query.getSingleResult();
        } catch (Exception e){
            user = null;
        }
        return user;
    }
}
