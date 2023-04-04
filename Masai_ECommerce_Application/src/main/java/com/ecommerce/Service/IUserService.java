package com.ecommerce.Service;

import com.ecommerce.Entity.User;
import com.ecommerce.GlobalExceptionHandler.UserException;

public interface IUserService {

	public User registerUser(User user);
	
	boolean loginUser(User user);
	
	User viewUser(Integer userId) throws UserException;
}
