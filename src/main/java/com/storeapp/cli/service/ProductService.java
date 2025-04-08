package com.storeapp.cli.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storeapp.cli.dto.ProductDisplayDTO;
import com.storeapp.cli.model.Product;
import com.storeapp.cli.model.SpecialOffer;
import com.storeapp.cli.repository.ProductRepository;
import com.storeapp.cli.repository.SpecialOfferRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private SpecialOfferRepository specialOfferRepository;
	

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElse(null);
	}
	
	public List<ProductDisplayDTO> getDisplayProductList() {
	    List<Product> products = productRepo.findAll();
	    List<ProductDisplayDTO> dtoList = new ArrayList<>();
	    
	    
	    for (Product product : products) {
	    	
	        ProductDisplayDTO dto = new ProductDisplayDTO();
	        dto.setProductId(product.getId());
	        dto.setName(product.getName());
	        dto.setDescription(product.getDescription());
	        dto.setPrice(product.getPrice());
	        
	        Optional<SpecialOffer> offer = specialOfferRepository.findByProductId(product.getId());
	        
	        if (offer.isPresent()) {
	            dto.setSpecDesc(offer.get().getSpecDescription());
	            dto.setSpecPrice(offer.get().getSpecPrice());
	            dto.setSpecQty(offer.get().getQuantity());
	        }
	
	        dtoList.add(dto);
	    }

        return dtoList;
	}

}
