package ru.spring.zheleznov.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.zheleznov.webapp.model.Product;
import ru.spring.zheleznov.webapp.services.ProductServices;

import java.util.List;

@Controller
public class ControllerProduct {
    private ProductServices productServices;

    @Autowired
    public void setProductServices(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/product")
    public String productPage(Model model) {
        List<Product> productList = productServices.info();
        model.addAttribute("products", productList);
        return "hello";
    }

    @GetMapping("/delete_product/{id}")
    public String productDelet(@PathVariable long id) {
        productServices.removeProduct(id);
        return "redirect:/product";
    }

    @PostMapping("/add_product")
    public String productAdd(@RequestParam String title, long cost) {
        productServices.addProduct(title, cost);
        return "redirect:/product";
    }
    @GetMapping("/add_product1")
    public String addProductPage(){
        return "add_product";
    }
}
