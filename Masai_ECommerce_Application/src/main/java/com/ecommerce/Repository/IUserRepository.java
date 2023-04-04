package com.ecommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String email);
}
