package com.Product.ProductManagement.service;

import com.Product.ProductManagement.Repository.Jpa.CategoryRepository;
import com.Product.ProductManagement.dto.Category;
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

        public List<Category> getAllCategories() {
            return categoryRepository.findAll();
        }
    }


