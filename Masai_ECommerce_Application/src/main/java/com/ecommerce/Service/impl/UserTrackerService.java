package com.ecommerce.Service.impl;

import java.util.Objects;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Entity.User;
import com.ecommerce.Entity.UserTracker;
import com.ecommerce.GlobalExceptionHandler.UserException;
import com.ecommerce.Repository.IUserRepository;
import com.ecommerce.Repository.IUserTrackerRepository;

@Service
public class UserTrackerService {

	@Autowired
	private IUserTrackerRepository userTrackerRepository;

	@Autowired
	private IUserRepository userRepository;

	public boolean loginUser(User user) throws UserException {

		try {

			User userDB = userRepository.findByEmail(user.getEmail()).get();

			if (userDB == null)
				throw new UserException("User not found");

			if (!Objects.equals(userDB.getPassword(), user.getPassword()))
				return false;

			UserTracker ut = new UserTracker();
			ut.setEmail(userDB.getEmail());
			userTrackerRepository.save(ut);

		} catch (ConstraintViolationException e) {

			return false;
		}

		return true;
	}

}
