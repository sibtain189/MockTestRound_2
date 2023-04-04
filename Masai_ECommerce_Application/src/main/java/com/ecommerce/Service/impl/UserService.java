package com.ecommerce.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.ecommerce.Entity.User;
import com.ecommerce.GlobalExceptionHandler.UserException;
import com.ecommerce.Repository.IUserRepository;
import com.ecommerce.Repository.IUserTrackerRepository;
import com.ecommerce.Service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private UserTrackerService userTrackerService;

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public boolean loginUser(User user) {
		// TODO Auto-generated method stub

		return userTrackerService.loginUser(user);

	}

	@Override
	public User viewUser(Integer userId) throws UserException {
		// TODO Auto-generated method stub
		
		User user = userRepo.findById(userId).orElseThrow(()-> new UserException(("User doesn't exist with this ID " + userId)));
		
		return user;
	}

}
