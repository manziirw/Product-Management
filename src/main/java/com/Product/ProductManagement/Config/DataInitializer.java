//package com.Product.ProductManagement.Config;
//
//
//
//import com.Product.ProductManagement.dto.Category;
//import com.Product.ProductManagement.Repository.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final CategoryRepository categoryRepository;
//
//    @Autowired
//    public DataInitializer(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Initialize categories
//        List<Category> categories = Arrays.asList(
//                new Category("Category A"),
//                new Category("Category B"),
//                new Category("Category C")
//        );
//
//        // Save categories to the database
//        categoryRepository.saveAll(categories);
//    }
//}

