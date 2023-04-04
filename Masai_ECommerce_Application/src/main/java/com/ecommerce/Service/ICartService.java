package com.ecommerce.Service;

import com.ecommerce.Entity.Cart;

public interface ICartService {

	public Cart addCart(Cart cart, Integer userId);
	
}
