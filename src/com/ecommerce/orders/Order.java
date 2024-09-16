package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
    // Attributes
    private String orderID;
    private Customer customer;
    private List<Product> products;
    private double orderTotal;
    private String orderStatus;
    private Date orderDate;

    // Constructor
    public Order(Customer customer, List<Product> products) {
        this.orderID = generateOrderID();
        this.customer = customer;
        this.products = products;
        this.orderTotal = calculateOrderTotal();
        this.orderStatus = "Pending";
        this.orderDate = new Date();
    }

    // Getters and Setters
    public String getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    // Methods
    private String generateOrderID() {
        return UUID.randomUUID().toString();
    }

    private double calculateOrderTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public String generateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order ID: ").append(orderID)
                .append("\nCustomer: ").append(customer.getName())
                .append("\nOrder Date: ").append(orderDate)
                .append("\nOrder Status: ").append(orderStatus)
                .append("\nProducts:\n");

        for (Product product : products) {
            summary.append("- ").append(product.getName())
                    .append(" ($").append(product.getPrice()).append(")\n");
        }

        summary.append("Order Total: $").append(orderTotal);
        return summary.toString();
    }

    public void updateOrderStatus(String status) {
        this.orderStatus = status;
        System.out.println("Order status updated to: " + status);
    }

    public String getOrderInformation() {
        return generateOrderSummary();
    }
}
