package com.ra.QUẢNLYCAFE.model;

public class Category {
    private String categoryId;
    private String categoryName;
    private boolean status;

    // Constructors
    public Category() {
    }

    public Category(String categoryId, String categoryName, boolean status) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.status = status;
    }

    // Getters and setters
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
