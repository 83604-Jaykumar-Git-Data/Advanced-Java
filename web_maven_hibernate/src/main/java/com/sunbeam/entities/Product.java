package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product extends BaseEntity{
	
	@Column(name ="product_name",unique=true,length = 30)
	private String productName;
	
	@Column(name="product_price")
	private double price;
	
	@Column(name="Quantity")
	private int qty;
//	Product *-->1 Category (many-to-one)
	@ManyToOne //Mandatory , otherwise MappingException
	//optional BUT recommended, to specify name
	// of ForeignKey column n adding NOT NULL constraint
	
	@JoinColumn(name="category_id", nullable = false)
	
	private Category productCategory;
	
	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	public Product(String productName, double price, int qty) {
		this.productName = productName;
		this.price = price;
		this.qty = qty;
	}

	public Product() {
		
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Product [id=" +getId() + ", productName=" + productName + ", price=" + price + ", qty=" + qty + "]";
	}
	
	
	
	
}
