package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
