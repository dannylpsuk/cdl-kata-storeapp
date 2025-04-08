package com.storeapp.cli.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeapp.cli.model.SpecialOffer;

public interface SpecialOfferRepository extends JpaRepository <SpecialOffer, Long>{

	Optional<SpecialOffer> findByProductId(Long productId);
}

