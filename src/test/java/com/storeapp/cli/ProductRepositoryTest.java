package com.storeapp.cli;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import com.storeapp.cli.ProductApplication;
import com.storeapp.cli.model.Product;
import com.storeapp.cli.repository.ProductRepository;

@SpringBootTest(classes = ProductApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext(classMode = org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductRepositoryTest {
	
	@Autowired
    private ProductRepository productRepository;


	@Test
	void getAllProducts() {
		
		List<Product> allProductList = 	productRepository.findAll();
		for (Product p : allProductList) {
			System.out.println(p.toString());
		}
		//assertTrue(true);
	}

}
