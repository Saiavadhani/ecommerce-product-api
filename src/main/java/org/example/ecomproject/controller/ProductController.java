package org.example.ecomproject.controller;

import org.example.ecomproject.model.Product;
import org.example.ecomproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
   @Autowired
   ProductService service;

    @GetMapping("/")
    public String greet(){
    return "Welcome to the Website!!";
}
   @GetMapping("/products")
   public List<Product> getProducts(){
       return service.getProducts();
   }
   @GetMapping("/products/{prodId}")
   public Product getProductById(@PathVariable int prodId){
      return  service.getProductById(prodId);
   }
   @PostMapping("/products")
   public void addProduct(@RequestBody Product prod){
       service.addProduct(prod);
   }
    @PostMapping("/products/many")
    public void addProducts(@RequestBody List<Product> products){
        service.addProducts(products);
    }
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }
    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
    }
}
