package com.Product.ProductManagement.tree;

import com.Product.ProductManagement.dto.Category;
import com.Product.ProductManagement.dto.Product;

public class BinaryTree {
    private TreeNode root;

    // Add a product to the tree
    public void addProduct(Category category, Product product) {
        root = addRecursive(root, category, product);
    }

    private TreeNode addRecursive(TreeNode current, Category category, Product product) {
        if (current == null) {
            return new TreeNode(category);
        }

        if (category.getName().compareTo(current.getCategory().getName()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), category, product));
        } else if (category.getName().compareTo(current.getCategory().getName()) > 0) {
            current.setRight(addRecursive(current.getRight(), category, product));
        } else {
            // Category already exists, add the product to this category
            current.setProduct(product);
        }

        return current;
    }

    // Delete a product from the tree
    public void deleteProduct(Category category) {
        root = deleteRecursive(root, category);
    }

    private TreeNode deleteRecursive(TreeNode current, Category category) {
        if (current == null) {
            return null;
        }

        if (category.getName().equals(current.getCategory().getName())) {
            // Node to delete found
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }
            if (current.getLeft() == null) {
                return current.getRight();
            }

            Category smallestCategory = findSmallestCategory(current.getRight());
            current.setCategory(smallestCategory);
            current.setRight(deleteRecursive(current.getRight(), smallestCategory));
            return current;

        }
        if (category.getName().compareTo(current.getCategory().getName()) < 0) {
            current.setLeft(deleteRecursive(current.getLeft(), category));
            return current;
        }

        current.setRight(deleteRecursive(current.getRight(), category));
        return current;
    }

    private Category findSmallestCategory(TreeNode root) {
        return root.getLeft() == null ? root.getCategory() : findSmallestCategory(root.getLeft());
    }

    // Search for a product in the tree
    public Product searchProduct(Category category) {
        return searchRecursive(root, category);
    }

    private Product searchRecursive(TreeNode current, Category category) {
        if (current == null) {
            return null;
        }

        if (category.getName().equals(current.getCategory().getName())) {
            return current.getProduct();
        }

        return category.getName().compareTo(current.getCategory().getName()) < 0
                ? searchRecursive(current.getLeft(), category)
                : searchRecursive(current.getRight(), category);
    }
}
