package com.example.demo.service;

import com.example.demo.models.Product;
import com.example.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    ProductRepo productRepo;
    @Override
    public List<Product> getProducts() {
      return  productRepo.getProducts();
    }

    public  List<Product>  updateProduct(Product product) {
        List<Product> products = productRepo.getProducts();

        for(Product eachProduct:products) {
            if(eachProduct.getProductId() == product.getProductId()) {
                eachProduct.setProductName(product.getProductName());
                eachProduct.setPrice(product.getPrice());
            }
        }
        return products;
    }

    public List<Product> deleteProduct(Product product) {
        List<Product> products = productRepo.getProducts();
        for(Product eachProduct:products) {
            if(eachProduct.getProductId() == product.getProductId()) {
                products.remove(eachProduct);
                break;
            }
        }
        return products;
    }

    public List<Product> deleteProductById(Integer productId) {
        List<Product> products = productRepo.getProducts();
        for(Product eachProduct:products) {
            if(eachProduct.getProductId() == productId) {
                products.remove(eachProduct);
                break;
            }
        }
        return products;
    }

    public List<Product> deleteProductByIdAndPrice(Integer productId, Integer price) {
        List<Product> products = productRepo.getProducts();
        for(Product eachProduct:products) {
            if(price!=null) {
                if(eachProduct.getProductId() == productId) {
                    products.remove(eachProduct);
                    break;
                }
            } else {
                if(eachProduct.getProductId() == productId) {
                    products.remove(eachProduct);
                    break;
                }
            }
        }
        return products;
    }
}
