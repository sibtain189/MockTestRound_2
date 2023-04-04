package com.ecommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Entity.UserTracker;

@Repository
public interface IUserTrackerRepository extends JpaRepository<UserTracker, Integer> {

	Optional<UserTracker> findByUserId(Integer userId);

}