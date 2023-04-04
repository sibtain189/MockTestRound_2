package com.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Entity.Product;
import com.ecommerce.Entity.User;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

}
