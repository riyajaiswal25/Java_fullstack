package com.example.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entities.Category;
import com.example.app.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category createCategory(Category category)
	{
		return categoryRepository.save(category);
	}
	
	public Category fetch(Integer id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product Not Exists in Database"));
	}
	
	public Category update(Category category, Integer id) {
		Category dbcategory = fetch(id);
		dbcategory.setName(category.getName());
		dbcategory.setDescription(category.getDescription());
		dbcategory.setParentCat(category.getParentCat());
		dbcategory.setProducts(category.getProducts());
		dbcategory.setSubCat(category.getSubCat());
		return categoryRepository.save(dbcategory);
	}
	
	public void deleteCategory(Integer id) {
		boolean isExists = categoryRepository.existsById(id);
		if(isExists) {
			categoryRepository.deleteById(id);
		}
		else {
			throw new RuntimeException("Record not found in DB");
		}
	}

}
