package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Entity.User;
import com.ecommerce.GlobalExceptionHandler.UserException;
import com.ecommerce.Service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("/save")
	public ResponseEntity<User> saveUserDetailsHandler(@RequestBody User user) {
		return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> userLoginHandler(@RequestBody User user) {

		try {
			boolean loginSuccessful = userService.loginUser(user);

			if (loginSuccessful)
				return new ResponseEntity<>("login successful", HttpStatus.OK);

			return new ResponseEntity<>("passwords don't match", HttpStatus.UNAUTHORIZED);

		} catch (UserException e) {

			return new ResponseEntity<>("User does not exist", HttpStatus.BAD_REQUEST);
		}
	}

}
