package com.storeapp.cli.dto;

import java.util.List;

import com.storeapp.cli.model.Product;
import com.storeapp.cli.model.SpecialOffer;

public class CheckoutRequestDTO {
	
	private List<Product> cart;
	private List<SpecialOffer> offers;
	
	
	public List<Product> getCart() {
		return cart;
	}
	public void setCart(List<Product> cart) {
		this.cart = cart;
	}
	public List<SpecialOffer> getOffers() {
		return offers;
	}
	public void setOffers(List<SpecialOffer> offers) {
		this.offers = offers;
	}
	
	

}
