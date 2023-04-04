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

import com.ecommerce.Entity.Cart;
import com.ecommerce.Entity.User;
import com.ecommerce.Repository.ICartRepository;
import com.ecommerce.Service.ICartService;
import com.ecommerce.Service.IProductService;
import com.ecommerce.Service.IUserService;


@Service
public class CartService implements ICartService{

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICartRepository cartRepository;
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IProductService productService;
	
	@Override
	public Cart addCart(Cart cart, Integer userId) {
		// TODO Auto-generated method stub
		cart.setUser(userService.viewUser(userId));
		Integer quant = productService.getAllProduct().size();
		cart.setQuantity(quant);
		return cartRepository.save(cart);
	}

	
}
