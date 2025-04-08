package com.storeapp.cli.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	//name, price, description
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private Long id;

	@Column(nullable = false)
	private String sku;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Double price;
	
    @Column(nullable = false)
    private String description;

    // Constructors
    public Product() {}
    
    public Product(Long id, String sku, String name, Double price, String description) {
    	this.id = id;
    	this.sku = sku;
    	this.name = name;
    	this.price = price;
    	this.description = description;
    }
    
    	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", sku=" + sku + ", name=" + name + ", price=" + price
				+ ", description=" + description + "]";
	}

	 
    

}
