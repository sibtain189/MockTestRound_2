package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Entity.Cart;
import com.ecommerce.Entity.Product;
import com.ecommerce.Service.ICartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ICartService cartService;
	
	@GetMapping("/{pId}")
	public ResponseEntity<Cart> addToCart(@RequestBody Cart re, @RequestParam Integer pId){
		
		return new ResponseEntity<Cart>( cartService.addCart(re, pId),HttpStatus.OK);
		
	}
	
}
