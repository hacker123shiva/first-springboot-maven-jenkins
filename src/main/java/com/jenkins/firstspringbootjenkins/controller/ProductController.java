package com.jenkins.firstspringbootjenkins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jenkins.firstspringbootjenkins.Service.ProductService;
import com.jenkins.firstspringbootjenkins.entity.Product;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        System.out.println("Product added successfully");
        return "redirect:/product";

    }

    @GetMapping("/product/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @GetMapping("/product")
    public String getProduct(Model model) {
        model.addAttribute("products", productService.getProducts());
        System.out.println("Product fetched successfully");
        return "product";
    }

    @PostMapping("/product/update")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productService.updateProduct(product);
        System.out.println("Product updated successfully");
        return "redirect:/product";
    }

    @GetMapping("/product/delete")
    public String delteProductPage() {
        return "delete-product";
    }

    @GetMapping("/product/update")
    public String showUpdateProductForm() {
        return "update-product";
    }

    @PostMapping("/product/delete")
    public String deleteProduct(@ModelAttribute("product") Product product) {
        System.out.println(product.getId());
        productService.deleteProduct(product.getId());
        System.out.println("Product deleted successfully");
        return "redirect:/product";
    }

    @GetMapping("/product/{id}")
    public String getProductById(@ModelAttribute("product") Product product) {
        productService.getProductById(product.getId());
        System.out.println("Product fetched by id successfully");
        return "product";
    }

}
