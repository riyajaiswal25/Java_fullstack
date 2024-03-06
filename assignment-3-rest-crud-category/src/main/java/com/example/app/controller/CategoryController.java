package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entities.Category;
import com.example.app.services.CategoryService;



@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}
	
	@GetMapping("/{id}")
	public Category fetchProduct(@PathVariable Integer id) {
		return categoryService.fetch(id);
	}
	
	@PutMapping("/{id}")
	public Category updateProduct(@PathVariable Integer id, @RequestBody Category category) {
		return categoryService.update(category,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
	}

}
