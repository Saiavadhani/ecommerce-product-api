package org.example.ecomproject.service;

import org.example.ecomproject.model.Product;
import org.example.ecomproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public Product addProduct(Product prod, MultipartFile imageFile) throws IOException {
        prod.setImageName(imageFile.getOriginalFilename());
        prod.setImageType(imageFile.getContentType());
        prod.setImageData(imageFile.getBytes());
        return repo.save(prod);
    }
    public void addProducts(List<Product> products){
        repo.saveAll(products);
    }
    public void updateProduct(int id, Product prod,MultipartFile imageFile) throws IOException {
        if(imageFile!=null && !imageFile.isEmpty()) {
            prod.setImageData(imageFile.getBytes());
            prod.setImageName(imageFile.getOriginalFilename());
            prod.setImageType(imageFile.getContentType());
        }
        else{
            Product existing = repo.findById(id).get();
            prod.setImageData(existing.getImageData());
            prod.setImageName(existing.getImageName());
            prod.setImageType(existing.getImageType());
        }
        repo.save(prod);
    }
    public void deleteProduct(int prodId ){

        repo.deleteById(prodId);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
