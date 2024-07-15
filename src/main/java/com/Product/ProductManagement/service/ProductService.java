package com.Product.ProductManagement.service;

import com.Product.ProductManagement.Repository.Jpa.CategoryRepository;
import com.Product.ProductManagement.Repository.Jpa.ProductRepository;
import com.Product.ProductManagement.dto.Category;
import com.Product.ProductManagement.dto.Product;
import com.Product.ProductManagement.tree.BinaryTree;
import jakarta.transaction.Transactional;
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
    private final BinaryTree binaryTree;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.binaryTree = new BinaryTree();
    }

    // Create operation
    public Product addProduct(Product product, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + categoryId + " not found"));

        binaryTree.addProduct(category, product);
        product.setCategory(category);
        return productRepository.save(product);
    }

    // Read operation with pagination and sorting
    public Page<Product> getAllProducts(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return productRepository.findAll(pageable);
    }


    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product updateProduct(Long productId, Product updatedProduct) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product with id " + productId + " not found"));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setReleaseDate(updatedProduct.getReleaseDate());

        // Update category if necessary
        if (updatedProduct.getCategory() != null) {
            Category category = categoryRepository.findById(updatedProduct.getCategory().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Category with id " + updatedProduct.getCategory().getId() + " not found"));
            existingProduct.setCategory(category);
        }

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " not found"));

        binaryTree.deleteProduct(product.getCategory());
        productRepository.deleteById(id);
    }

    public Product searchProduct(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + categoryId + " not found"));

        return binaryTree.searchProduct(category);
    }
}
