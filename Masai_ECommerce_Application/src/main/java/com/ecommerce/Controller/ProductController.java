package com.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Entity.Product;
import com.ecommerce.Entity.User;
import com.ecommerce.Service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProducHandler(@RequestBody Product product){
		return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProductHandler(){
		return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> getDeleteById(@PathVariable("id") Integer id){
		
		Product sDeleteProduct = productService.deleteProductById(id);
		
		return new ResponseEntity<Product>(sDeleteProduct,HttpStatus.ACCEPTED);
		
	}
	
	
	
}
