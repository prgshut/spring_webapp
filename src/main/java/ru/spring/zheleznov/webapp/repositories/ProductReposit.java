package ru.spring.zheleznov.webapp.repositories;

import org.springframework.stereotype.Component;
import ru.spring.zheleznov.webapp.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductReposit {
    private List<Product> productList;

    @PostConstruct
    private void init() {
        productList = new ArrayList<Product>(Arrays.asList(
                new Product(1L, "Белый", 25),
                new Product(2L, "Red", 15),
                new Product(3L, "Yellow", 25),
                new Product(4L, "Yellow", 22)
        ));
    }

    public List<Product> info(){
        return Collections.unmodifiableList(productList);
    }

    public List<Product> info(long id) {
        return productList.stream().filter(p->p.getId()==id).collect(Collectors.toList());
    }
    public void addProduct(String title, long cost){
        long maxid=0;
        for (Product p : productList) {
            if (p.getId()>maxid){
                maxid=p.getId();
            }
        }
        maxid++;
        productList.add(new Product(maxid,title,cost));
    }
    public void removProduct(long id){
        Product removeProd = null;
        for (Product p : productList) {
            if (p.getId()==id){
                removeProd=p;
            }
        }
        productList.remove(removeProd);
//        productList.removeIf(product -> product.getId()==id);
    }

}
