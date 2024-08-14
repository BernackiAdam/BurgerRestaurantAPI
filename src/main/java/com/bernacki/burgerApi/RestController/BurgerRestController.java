package com.bernacki.burgerApi.RestController;

import com.bernacki.burgerApi.Entity.Burger;
import com.bernacki.burgerApi.Service.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BurgerRestController {

    @Autowired
    private BurgerService burgerService;

    @GetMapping("/burgers")
    public List<Burger> findAll(){
        return burgerService.findAll();
    }

    @GetMapping("/burgers/{burgerId}")
    public Burger findById(@PathVariable int burgerId){
        return burgerService.findById(burgerId);
    }
}
