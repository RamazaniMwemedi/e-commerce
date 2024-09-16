import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.orders.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Simulated Product Catalog
    private static List<Product> productCatalog = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize Product Catalog
        initializeProductCatalog();

        // Create a Customer
        Customer customer = new Customer("C001", "Alice");

        // Simulate Browsing and Shopping
        Scanner scanner = new Scanner(System.in);
        boolean shopping = true;

        while (shopping) {
            System.out.println("\nWelcome to the Online Store!");
            System.out.println("1. Browse Products");
            System.out.println("2. View Shopping Cart");
            System.out.println("3. Place Order");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    browseProducts(customer, scanner);
                    break;
                case "2":
                    viewShoppingCart(customer);
                    break;
                case "3":
                    placeOrder(customer);
                    break;
                case "4":
                    shopping = false;
                    System.out.println("Thank you for visiting the Online Store!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void initializeProductCatalog() {
        productCatalog.add(new Product("P001", "Laptop", 1500.0, "High-performance laptop", "Electronics", 10));
        productCatalog.add(new Product("P002", "Smartphone", 800.0, "Latest smartphone model", "Electronics", 20));
        productCatalog.add(new Product("P003", "Tablet", 600.0, "Portable tablet device", "Electronics", 15));
        productCatalog.add(new Product("P004", "Smartwatch", 250.0, "Smartwatch with fitness tracking", "Wearables", 30));
        productCatalog.add(new Product("P005", "Wireless Earbuds", 150.0, "Noise-cancelling earbuds", "Accessories", 50));
        // Add more products as needed
    }

    private static void browseProducts(Customer customer, Scanner scanner) {
        System.out.println("\nAvailable Products:");
        for (Product product : productCatalog) {
            System.out.println(product.getProductID() + ": " + product.getName() + " ($" + product.getPrice() + ")");
        }

        System.out.print("Enter the Product ID to add to cart (or type 'back' to return): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("back")) {
            return;
        }

        Product selectedProduct = null;
        for (Product product : productCatalog) {
            if (product.getProductID().equalsIgnoreCase(input)) {
                selectedProduct = product;
                break;
            }
        }

        if (selectedProduct != null) {
            customer.addProductToCart(selectedProduct);
        } else {
            System.out.println("Product not found. Please try again.");
        }
    }

    private static void viewShoppingCart(Customer customer) {
        List<Product> cart = customer.getShoppingCart();
        if (cart.isEmpty()) {
            System.out.println("\nYour shopping cart is empty.");
        } else {
            System.out.println("\nYour Shopping Cart:");
            for (Product product : cart) {
                System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
            }
            System.out.println("Total Cost: $" + customer.calculateTotalCost());
        }
    }

    private static void placeOrder(Customer customer) {
        Order order = customer.placeOrder();
        if (order != null) {
            System.out.println("\nOrder Summary:");
            System.out.println(order.generateOrderSummary());
            // Update product stock quantities if needed
        }
    }
}
