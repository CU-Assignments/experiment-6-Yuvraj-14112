import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + category + ", $" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.00),
            new Product("Smartphone", "Electronics", 800.00),
            new Product("TV", "Electronics", 1500.00),
            new Product("Shoes", "Fashion", 100.00),
            new Product("Jeans", "Fashion", 60.00),
            new Product("Blender", "Home Appliances", 150.00),
            new Product("Microwave", "Home Appliances", 200.00)
        );

        // Group products by category
        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(product -> product.category));
        System.out.println("Products grouped by category: " + productsByCategory);

        // Find the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                product -> product.category,
                Collectors.maxBy(Comparator.comparingDouble(product -> product.price))
            ));
        System.out.println("Most expensive product in each category: " + mostExpensiveByCategory);

        // Calculate the average price of all products
        double averagePrice = products.stream()
            .mapToDouble(product -> product.price)
            .average()
            .orElse(0.0);
        System.out.println("Average price of all products: $" + averagePrice);
    }
}
