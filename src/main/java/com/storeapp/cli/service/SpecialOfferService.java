package com.storeapp.cli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storeapp.cli.model.SpecialOffer;
import com.storeapp.cli.repository.SpecialOfferRepository;

@Service

public class SpecialOfferService {
	
	@Autowired
	private SpecialOfferRepository specOfferRepo;
	
	

	public List<SpecialOffer> getAllSpecialOffers() {
		// TODO Auto-generated method stub
		return specOfferRepo.findAll();
	}

	public SpecialOffer getSpecialOfferById(Long id) {
		// TODO Auto-generated method stub
		return specOfferRepo.findById(id).orElse(null);
	}
	
	public SpecialOffer getSpecialOfferByProductId(Long id) {
		// TODO Auto-generated method stub
		return specOfferRepo.findById(id).orElse(null);
	}
	
	
}
