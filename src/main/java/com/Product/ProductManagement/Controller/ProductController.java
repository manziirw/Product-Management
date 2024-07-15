package com.Product.ProductManagement.Controller;

import com.Product.ProductManagement.dto.ApiResponse;
import com.Product.ProductManagement.dto.Product;
import com.Product.ProductManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add/{categoryId}")
    public ResponseEntity<ApiResponse<Product>> addProduct(@RequestBody Product product, @PathVariable Long categoryId) {
        Product savedProduct = productService.addProduct(product, categoryId);
        ApiResponse<Product> response = new ApiResponse<>(true, "Product added successfully", savedProduct);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<Page<Product>>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        Page<Product> products = productService.getAllProducts(page, size, sortBy);
        ApiResponse<Page<Product>> response = new ApiResponse<>(true, "Products retrieved successfully", products);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Product>>> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        ApiResponse<Optional<Product>> response = new ApiResponse<>(true, "Product retrieved successfully", product);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(
            @PathVariable Long productId,
            @RequestBody Product updatedProduct) {
        Product updated = productService.updateProduct(productId, updatedProduct);
        ApiResponse<Product> response = new ApiResponse<>(true, "Product updated successfully", updated);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        ApiResponse<Void> response = new ApiResponse<>(true, "Product deleted successfully", null);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Product>> searchProduct(@RequestParam Long categoryId) {
        Product product = productService.searchProduct(categoryId);
        ApiResponse<Product> response = new ApiResponse<>(true, "Product found", product);
        return ResponseEntity.ok(response);
    }
//    @GetMapping("/search")
//    public List<Product> findByNameContaining(@RequestParam String name) {
//        return productService.findByNameContaining(name);
//    }

    @GetMapping("/category/{categoryId}")
    public List<Product> findByCategoryId(@PathVariable Long categoryId) {
        return productService.findByCategoryId(categoryId);
    }

    @GetMapping("/price")
    public Page<Product> findByPriceGreaterThan(@RequestParam double price, Pageable pageable) {
        return productService.findByPriceGreaterThan(price, pageable);
    }
}
