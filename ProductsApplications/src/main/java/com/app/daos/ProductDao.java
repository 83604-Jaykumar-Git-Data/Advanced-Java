package com.app.daos;

import java.util.List;

import com.app.pojos.Category;
import com.app.pojos.Product;

public interface ProductDao {
   String insertProduct(Product product);
   Product fetchProduct(Long id);
   List<Product> fetchAllProducts();
   List<Product> getProductJPACtorExpression(Category category);
   List<Product> getProductsByCategory(Category category);
   List<Integer> getProductsByAvailableQuantity(Category category);
   String  updateProductAvailableQuantity(Long id , int availableQuantity);
   String  updateProductAvailableQuantityByValue(Category category , int value);
   String deleteUserDetails(String productName);
   String deleteUserDetails(Long userId);
}
