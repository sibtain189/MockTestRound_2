package com.ecommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Entity.Cart;
import com.ecommerce.Entity.User;

public interface ICartRepository extends JpaRepository<Cart, Integer>{
	Optional<Cart> findByUser(User user);
}
