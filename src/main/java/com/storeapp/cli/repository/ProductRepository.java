package com.storeapp.cli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeapp.cli.model.Product;

public interface ProductRepository extends JpaRepository <Product, Long>{

}
