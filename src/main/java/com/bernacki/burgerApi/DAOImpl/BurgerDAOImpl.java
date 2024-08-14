package com.bernacki.burgerApi.DAOImpl;

import com.bernacki.burgerApi.DAO.BurgerDAO;
import com.bernacki.burgerApi.Entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BurgerDAOImpl implements BurgerDAO {

    EntityManager entityManager;

    @Autowired
    public BurgerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery(
                "FROM Burger", Burger.class
        );
        return query.getResultList();
    }

    @Override
    public Burger findById(int id) {
        return entityManager.find(Burger.class, id);
    }

    @Override
    public void save(Burger burger) {
        entityManager.persist(burger);
    }

    @Override
    public void deleteById(int id) {
        Burger burger = entityManager.find(Burger.class, id);
        entityManager.remove(burger);
    }
}
