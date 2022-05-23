package com.example.demo.controller;

import com.example.demo.models.Product;
import com.example.demo.models.Response;
import com.example.demo.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductServiceImp  productServiceImp;

    @GetMapping("/getProducts")
//    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Product>  getProducts() {
//        ProductServiceImp  productServiceImp = new ProductServiceImp();
        List<Product>  products = productServiceImp.getProducts();
        return products;
    }

    @PostMapping("/postProducts")
    //@RequestBody - automatic deserialization (HttpRequestBody > Java Object)
    public Response saveProducts(@RequestBody  Product product) {
        Response response = new Response();
        if(product.getProductId()!=0) {
            response.setMessage("Saved Product successfully!!!");
            response.setStatusCode(200);
        } else {
            response.setMessage("Sorry try again");
            response.setStatusCode(500);
        }
        return response;
    }

    @PutMapping("/updateProducts")
    public  List<Product>  updateProduct(@RequestBody  Product product) {
        return productServiceImp.updateProduct(product);
    }

//    @DeleteMapping("deleteProducts")
//    public List<Product>  deleteProduct(@RequestBody Product product) {
//        return productServiceImp.deleteProduct(product);
//    }

    @DeleteMapping("deleteProducts/{productId}")
    public List<Product>  deleteProduct(@PathVariable("productId") Integer productId) {
        return productServiceImp.deleteProductById(productId);
    }
    @DeleteMapping("deleteProducts")
    public String  deleteProductByQueryParam(@RequestParam(value = "productId") Optional<Integer> productId) {
        return "ID: "+productId.orElseGet(() -> 0);
//        Response response = new Response();
//        if(productId!=null) {
//            List<Product> products =  productServiceImp.deleteProductById(productId);
//            response.setStatusCode(200);
//            response.setMessage("Deleted successfully!!");
//        }
//        else {
//            response.setStatusCode(200);
//            response.setMessage("Please provide productId");
//        }
//        return response;
    }

    //DeleteMapping with query param (multiple)
//    @DeleteMapping("deleteProducts")
//    public Response  deleteProductByMultipleQueryParam(@RequestParam(value = "productId") Integer productId,@RequestParam(value = "price",required = false,defaultValue = "18000") Integer price) {
//        Response response = new Response();
//        if(productId!=null) {
//            List<Product> products =  productServiceImp.deleteProductByIdAndPrice(productId,price);
//            response.setStatusCode(200);
//            response.setMessage("Deleted successfully!!");
//        }
//        else {
//            response.setStatusCode(200);
//            response.setMessage("Please provide productId");
//        }
//        return response;
//    }

    //GET,POST,PUT,DELETE
    //write operations - POST - Non Idempotent
    // PUT - Idempotent
    // DELETE (safe)- Idempotent
    //read operations - GET - safe method- Idempotent
}
