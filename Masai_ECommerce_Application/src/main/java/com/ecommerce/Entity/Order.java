package com.ecommerce.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<Product> items;
    private Integer quantity;
    private String shippingAddress;
    private String paymentMethod;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    //getters and setters
}
