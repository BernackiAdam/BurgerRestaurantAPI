package com.bernacki.burgerApi.ServiceImpl;

import com.bernacki.burgerApi.DAO.BurgerDAO;
import com.bernacki.burgerApi.Entity.Burger;
import com.bernacki.burgerApi.Service.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BurgerServiceImpl implements BurgerService {

    private BurgerDAO burgerDAO;

    @Autowired
    public BurgerServiceImpl(BurgerDAO burgerDAO) {
        this.burgerDAO = burgerDAO;
    }

    @Override
    public List<Burger> findAll() {
        return burgerDAO.findAll();
    }

    @Override
    public Burger findById(int id) {
        return burgerDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Burger burger) {
        burgerDAO.save(burger);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        burgerDAO.deleteById(id);
    }
}
