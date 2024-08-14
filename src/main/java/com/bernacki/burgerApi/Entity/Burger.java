package com.bernacki.burgerApi.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "burger")
@Data
@NoArgsConstructor
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToMany(fetch = FetchType.EAGER
            , cascade = {CascadeType.DETACH, CascadeType.MERGE,
                        CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "burgers_toppings",
                joinColumns = @JoinColumn(name = "burger_id"),
                inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings;

    public Burger(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
