package com.bernacki.burgerApi.RestController;

import com.bernacki.burgerApi.Entity.Burger;
import com.bernacki.burgerApi.Service.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/burgers")
    public void save(Burger burger){
        burgerService.save(burger);
    }

    @DeleteMapping("/burgers/{burgerId}")
    public void deleteById(@PathVariable int burgerId){
        burgerService.deleteById(burgerId);
    }
}
