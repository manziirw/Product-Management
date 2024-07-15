package com.Product.ProductManagement.tree;

import com.Product.ProductManagement.dto.Category;
import com.Product.ProductManagement.dto.Product;

public class TreeNode {
    private Category category;
    private TreeNode left;
    private TreeNode right;
    private Product product;

    public TreeNode(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
