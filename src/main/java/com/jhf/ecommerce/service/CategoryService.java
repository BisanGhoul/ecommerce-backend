package com.jhf.ecommerce.service;

import com.jhf.ecommerce.model.Category;
import com.jhf.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Method to get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
