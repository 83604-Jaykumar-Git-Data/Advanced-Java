package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name="product_name" ,length=25)
    private String productName;
	@Enumerated(EnumType.STRING)
    private Category category;
    private double price;
    @Column(name="is_available_quantity")
    private int isAvailableQuantity;
    
    public Product(String productName, Category category, double price, int isAvailableQuantity) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.isAvailableQuantity = isAvailableQuantity;
    }

	public Product(String productName, double price, int isAvailableQuantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.isAvailableQuantity = isAvailableQuantity;
	}

	@Override
	public String toString() {
		if(category != null)
		return "Product [id=" + id + ", productName=" + productName + ", category=" + category + ", price=" + price
				+ ", isAvailableQuantity=" + isAvailableQuantity + "]";
		
		return "Product [productName=" + productName + ", price=" + price
				+ ", isAvailableQuantity=" + isAvailableQuantity + "]";
	}
    
}
