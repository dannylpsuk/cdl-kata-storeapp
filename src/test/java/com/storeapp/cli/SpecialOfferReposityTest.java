package com.storeapp.cli;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import com.storeapp.cli.ProductApplication;
import com.storeapp.cli.model.SpecialOffer;
import com.storeapp.cli.repository.SpecialOfferRepository;

@SpringBootTest(classes = ProductApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext(classMode = org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class SpecialOfferReposityTest {
	
	@Autowired
    private SpecialOfferRepository specOfferRepository;


	@Test
	void getAllSpecialOffers() {
		
		List<SpecialOffer> allSpecialOfferList = 	specOfferRepository.findAll();
		for (SpecialOffer sp : allSpecialOfferList) {
			System.out.println(sp.toString());
		}
		assertTrue(true);
	}

}



