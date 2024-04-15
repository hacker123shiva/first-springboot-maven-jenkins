package com.jenkins.firstspringbootjenkins.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jenkins.firstspringbootjenkins.entity.Product;

@Service
public class ProductService {

    private static List<Product> products = new ArrayList<>();

    // Constructor to add default products
    public ProductService() {
        // Add some default products
        products.add(new Product(1, "tomato", 10.99));
        products.add(new Product(2, "potato", 20.49));
        products.add(new Product(3, "brinjal", 15.75));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        products.stream().forEach(p -> {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
            }
        });
    }

    public void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    public Product getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().get();
    }
}
