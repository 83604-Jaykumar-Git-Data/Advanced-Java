package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// products table - id , category (BAKERY|SHOES|CLOTHES|STATIONAY) ,
//product name(unique)  , price , 
//available quantity
@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Category category;
	@Column(name ="product_name",unique=true,length = 30)
	private String productName;
	@Column(name="product_price")
	private double price;
	@Column(name="Quantity")
	private int qty;
	
	public Product() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Product(Category category, String productName, double price, int qty) {
		super();
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", productName=" + productName + ", price=" + price
				+ ", qty=" + qty + "]";
	}
	
	
	
}
