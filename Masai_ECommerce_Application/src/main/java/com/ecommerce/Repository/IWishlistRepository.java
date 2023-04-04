package com.ecommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Entity.User;
import com.ecommerce.Entity.Wishlist;

@Repository
public interface IWishlistRepository extends JpaRepository<Wishlist, Integer> {
    Optional<Wishlist> findByNameAndUser(String name, User user);
}