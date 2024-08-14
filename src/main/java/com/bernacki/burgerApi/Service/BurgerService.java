package com.bernacki.burgerApi.Service;

import com.bernacki.burgerApi.Entity.Burger;

import java.util.List;

public interface BurgerService {
    List<Burger> findAll();
    Burger findById(int id);
}
