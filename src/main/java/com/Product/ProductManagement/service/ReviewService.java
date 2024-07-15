package com.Product.ProductManagement.service;

import com.Product.ProductManagement.Repository.mongo.ReviewRepository;
import com.Product.ProductManagement.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviewsByProductId(String productId) {
        return reviewRepository.findByProductId(productId);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
}

