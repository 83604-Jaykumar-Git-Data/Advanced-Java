package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {
	String addProduct(Product product);
	Product getProductDetailsById(Long productId);
	
	List<Product> getAllProducts();
	
//	Display all the product details under specified category n between the given price range
	List<Product> getProductDetailsByCategoryAndPrice(double start, double end, Category cat);

	String applyDiscount(double discount,Category cat);
	
	String deleteProductDetails(String productName);
	
	String purchaseAproduct(Long productId, int qty);
	
}
