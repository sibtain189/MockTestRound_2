package com.ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Entity.Order;
import com.ecommerce.Entity.User;

public interface IOrderRepository extends JpaRepository<Order, Integer>{
	List<Order> findByUser(User user);
}
