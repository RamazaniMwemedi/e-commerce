package com.ecommerce;

public class Product {
    // Attributes
    private String productID;
    private String name;
    private double price;
    private String description;
    private String category;
    private int stockQuantity;

    // Constructors
    public Product() {
        // Default constructor
    }

    public Product(String productID, String name, double price, String description, String category, int stockQuantity) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }

    // Getters and Setters
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Other Methods
    public void reduceStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        } else if (quantity > stockQuantity) {
            throw new IllegalArgumentException("Insufficient stock.");
        } else {
            stockQuantity -= quantity;
        }
    }

    public void increaseStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        } else {
            stockQuantity += quantity;
        }
    }

    public double calculateTotalPrice(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + productID +
                "\nName: " + name +
                "\nPrice: $" + price +
                "\nDescription: " + description +
                "\nCategory: " + category +
                "\nStock Quantity: " + stockQuantity;
    }
}
