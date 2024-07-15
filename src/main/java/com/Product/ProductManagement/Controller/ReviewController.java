package com.Product.ProductManagement.Controller;

import com.Product.ProductManagement.dto.ApiResponse;
import com.Product.ProductManagement.dto.Review;
import com.Product.ProductManagement.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Review>> addReview(@RequestBody Review review) {
        Review savedReview = reviewService.addReview(review);
        ApiResponse<Review> response = new ApiResponse<>(true, "Review added successfully", savedReview);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse<List<Review>>> getReviewsByProductId(@PathVariable String productId) {
        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        ApiResponse<List<Review>> response = new ApiResponse<>(true, "Reviews retrieved successfully", reviews);
        return ResponseEntity.ok(response);
    }
}
