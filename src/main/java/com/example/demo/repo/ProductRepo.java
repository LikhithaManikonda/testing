package com.example.demo.repo;

import com.example.demo.models.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo {
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(01,"Laptop",38000));
        products.add(new Product(02,"Bag",3800));
        products.add(new Product(03,"Mobile",18000));
        products.add(new Product(04,"Charger",600));
        products.add(new Product(05,"SmartTV",60000));
        products.add(new Product(06,"MicroOven",100000));
        return products;
    }
}
