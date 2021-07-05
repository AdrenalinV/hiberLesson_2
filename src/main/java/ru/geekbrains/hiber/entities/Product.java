package ru.geekbrains.hiber.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="cost")
    private float cost;

    @ManyToMany
    @JoinTable(
            name="orders",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns =@JoinColumn(name="buyer_id")
    )
    private List<Buyer> buyers;

    public Product(String title,float cost){
        this.title=title;
        this.cost=cost;
    }
}
