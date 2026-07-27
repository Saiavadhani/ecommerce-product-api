package org.example.ecomproject.service;

import org.example.ecomproject.model.Product;
import org.example.ecomproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repo;
    public List<Product> getProducts(){
       return repo.findAll();
    }
    public Product getProductById(int prodId){
       return repo.findById(prodId).orElse(new Product());
    }
    public void addProduct( Product prod){
         repo.save(prod);
    }
    public void addProducts(List<Product> products){
        repo.saveAll(products);
    }
    public void updateProduct( Product prod){
        repo.save(prod);
    }
    public void deleteProduct(int prodId ){
        repo.deleteById(prodId);
    }
}
