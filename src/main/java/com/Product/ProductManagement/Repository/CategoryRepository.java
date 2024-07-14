package com.Product.ProductManagement.Repository;

import com.Product.ProductManagement.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

