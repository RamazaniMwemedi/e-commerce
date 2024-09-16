package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.orders.Order;

public class Customer {
    // Attributes
    private String customerID;
    private String name;
    private List<Product> shoppingCart;

    // Constructors
    public Customer() {
        shoppingCart = new ArrayList<>();
    }

    public Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        shoppingCart = new ArrayList<>();
    }

    // Getters and Setters
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    // Shopping Cart Operations
    public void addProductToCart(Product product) {
        shoppingCart.add(product);
        System.out.println(product.getName() + " has been added to your shopping cart.");
    }

    public void removeProductFromCart(Product product) {
        if (shoppingCart.remove(product)) {
            System.out.println(product.getName() + " has been removed from your shopping cart.");
        } else {
            System.out.println(product.getName() + " is not in your shopping cart.");
        }
    }

    public double calculateTotalCost() {
        double total = 0.0;
        for (Product product : shoppingCart) {
            total += product.getPrice();
        }
        return total;
    }

    public Order placeOrder() {
        if (shoppingCart.isEmpty()) {
            System.out.println("Your shopping cart is empty. Cannot place an order.");
            return null;
        }
        Order newOrder = new Order(this, new ArrayList<>(shoppingCart));
        shoppingCart.clear();
        System.out.println("Order placed successfully. Order ID: " + newOrder.getOrderID());
        return newOrder;
    }
}
