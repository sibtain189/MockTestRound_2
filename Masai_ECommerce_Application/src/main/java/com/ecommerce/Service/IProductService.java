package com.ecommerce.Service;

import java.util.List;

import com.ecommerce.Entity.Cart;
import com.ecommerce.Entity.Product;
import com.ecommerce.Entity.User;
import com.ecommerce.GlobalExceptionHandler.ProductException;

public interface IProductService {

	public Product saveProduct(Product poduct);
	
	public List<Product> getAllProduct();
	
	public Product deleteProductById(Integer id) throws ProductException;
	
	public Cart addItemsInCart(Integer id) throws ProductException;
}
