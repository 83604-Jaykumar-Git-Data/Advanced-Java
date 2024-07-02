package com.app.tester;

import java.util.List;
import java.util.Scanner;

import com.app.daos.ProductDao;
import com.app.daos.ProductDaoImpl;
import com.app.pojos.Category;
import com.app.pojos.Product;


public class HibernateTester {
    private static ProductDao productDao = new ProductDaoImpl();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	boolean flag = true;
        while (flag) {
            System.out.println("\n--- Product Management Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. View All Products");
            System.out.println("4. View Products by Category");
            System.out.println("5. Update Product Quantity");
            System.out.println("6. Update Product Quantity by Value");
            System.out.println("7. Delete Product");
            System.out.println("8. Delete Product by Product Name");
            System.out.println("9. View Product Name, Price, Available Quantity ");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
    
            switch (choice) {
            case 0:
            	System.out.println("Exiting...");
                flag = false;
            	   break;
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProduct();
                    break;
                case 3:
                    viewAllProducts();
                    break;
                case 4:
                    viewProductsByCategory();
                    break;
                case 5:
                    updateProductQuantity();
                    break;
                case 6:
                    updateProductQuantityByValue();
                    break;
                case 7:
                    deleteProduct();
                    break;
                case 8:
                    deleteProductByName();
                    break;
                case 9:
                	viewProductsDetailsByCategory();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name, category,price,Available Quantity: ");
        System.out.println(productDao.insertProduct(new Product(sc.next(), Category.valueOf(sc.next().toUpperCase()), sc.nextDouble(), sc.nextInt())));
    }

    private static void viewProduct() {
        System.out.print("Enter product ID: ");
        Long id = sc.nextLong();
          System.out.println(productDao.fetchProduct(id));
    }

    private static void viewAllProducts() {
        productDao.fetchAllProducts().forEach(System.out::println);
    }

    private static void viewProductsByCategory() {
        System.out.print("Enter category name: ");
        productDao.getProductsByCategory(Category.valueOf(sc.next().toUpperCase())).forEach(System.out::println);
    }

    private static void viewProductsDetailsByCategory() {
        System.out.print("Enter category name: ");
        productDao.getProductJPACtorExpression(Category.valueOf(sc.next().toUpperCase())).forEach(System.out::println);
    }
    private static void updateProductQuantity() {
        System.out.print("Enter product ID, NEW available quantity: ");
        System.out.println(productDao.updateProductAvailableQuantity(sc.nextLong(),sc.nextInt()));
    }

    private static void updateProductQuantityByValue() {
        System.out.print("Enter category name and value to update quantity by: ");
        System.out.println(productDao.updateProductAvailableQuantityByValue(Category.valueOf(sc.next().toUpperCase()), sc.nextInt()));

    }

    private static void deleteProduct() {
        System.out.print("Enter product ID: ");
        System.out.println(productDao.deleteUserDetails(sc.nextLong()));
    }
    private static void deleteProductByName() {
        System.out.print("Enter product Name: ");
        System.out.println(productDao.deleteUserDetails(sc.next()));
    }
}
