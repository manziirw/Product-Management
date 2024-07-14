package com.Product.ProductManagement.service;

import com.Product.ProductManagement.Repository.CategoryRepository;
import com.Product.ProductManagement.Repository.ProductRepository;
import com.Product.ProductManagement.dto.Category;
import com.Product.ProductManagement.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    // Create operation
    public Product addProduct(Product product, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + categoryId + " not found"));

        product.setCategory(category);
        return productRepository.save(product);
    }

    // Read operations
    public Page<Product> getAllProducts(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return productRepository.findAll(pageable);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Update operation
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete operation
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
