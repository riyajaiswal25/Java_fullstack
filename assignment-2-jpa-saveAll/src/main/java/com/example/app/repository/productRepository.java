package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entities.Product;

public interface productRepository extends JpaRepository<Product, Integer>{

}
