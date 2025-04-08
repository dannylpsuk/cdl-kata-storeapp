package com.storeapp.cli.dto;


public class ProductDisplayDTO {

	private Long productId;
	private String name;
	private String description;
	private double price;
	
	private String specDesc;
	private double specPrice;
	private int specQty;
	
	public ProductDisplayDTO() {
		
	}
	
	public ProductDisplayDTO(Long productId, String name, String description, double price, String specDesc,
			double specPrice, int specQty) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.specDesc = specDesc;
		this.specPrice = specPrice;
		this.specQty = specQty;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSpecDesc() {
		return specDesc;
	}

	public void setSpecDesc(String specDesc) {
		this.specDesc = specDesc;
	}

	public double getSpecPrice() {
		return specPrice;
	}

	public void setSpecPrice(double specPrice) {
		this.specPrice = specPrice;
	}

	public int getSpecQty() {
		return specQty;
	}

	public void setSpecQty(int specQty) {
		this.specQty = specQty;
	}

	@Override
	public String toString() {
		return "ProductDisplayDTO [productId=" + productId + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", specDesc=" + specDesc + ", specPrice=" + specPrice + ", specQty=" + specQty
				+ "]";
	}
	
		
	
	
	
}
