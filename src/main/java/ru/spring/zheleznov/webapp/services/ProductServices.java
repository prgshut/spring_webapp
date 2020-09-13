package ru.spring.zheleznov.webapp.services;

import org.springframework.stereotype.Component;
import ru.spring.zheleznov.webapp.model.Product;
import ru.spring.zheleznov.webapp.repositories.ProductReposit;

import java.util.List;
@Component
public class ProductServices {
    private ProductReposit productReposit;
    public ProductServices(ProductReposit productReposit) {
        this.productReposit=productReposit;
    }
    public List<Product> info(){
        return productReposit.info();
    }
    public List<Product> info(long id){
        return productReposit.info(id);
    }
    public void addProduct(String title, long cost){
        productReposit.addProduct(title,cost);
    }
    public void removeProduct(long id){
        productReposit.removProduct(id);
    }
}
