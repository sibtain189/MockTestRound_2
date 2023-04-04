package com.ecommerce.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Entity.Cart;
import com.ecommerce.Entity.Product;
import com.ecommerce.GlobalExceptionHandler.ProductException;
import com.ecommerce.Repository.ICartRepository;
import com.ecommerce.Repository.IProductRepository;
import com.ecommerce.Service.ICartService;
import com.ecommerce.Service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;
	
	@Autowired
	private ICartRepository cartRepository;
	
	@Autowired
	private ICartService cartService;

	@Override
	public Product saveProduct(Product poduct) {
		// TODO Auto-generated method stub
		return productRepository.save(poduct);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product deleteProductById(Integer id) throws ProductException {

		Product pDelete = productRepository.findById(id).orElseThrow(() -> new ProductException(id + " is not exists"));

		productRepository.delete(pDelete);
		// TODO Auto-generated method stub
		return pDelete;
	}

	@Override
	public Cart addItemsInCart(Integer id) throws ProductException {
		// TODO Auto-generated method stub

		Optional<Product> optional =	productRepository.findById(id);
		//
		if(optional.isPresent()) {
			
			Cart cart = new Cart();
			cart.setItems(getAllProduct());
			return cart;
		}else {
			throw new ProductException(id+" is not present");
		}

	}

}
