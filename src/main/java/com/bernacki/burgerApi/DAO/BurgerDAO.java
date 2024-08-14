package com.bernacki.burgerApi.DAO;

import com.bernacki.burgerApi.Entity.Burger;

import java.util.List;

public interface BurgerDAO {
    List<Burger> findAll();
    Burger findById(int id);
    void save(Burger burger);
    void deleteById(int id);

}
