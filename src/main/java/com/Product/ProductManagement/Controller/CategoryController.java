package com.Product.ProductManagement.Controller;

import com.Product.ProductManagement.utils.ApiResponse;
import com.Product.ProductManagement.dto.Category;
import com.Product.ProductManagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Category>>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        ApiResponse<List<Category>> response = new ApiResponse<>(true, "Categories retrieved successfully", categories);
        return ResponseEntity.ok(response);
    }
}
