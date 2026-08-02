package org.example.ecomproject.controller;

import org.example.ecomproject.model.Product;
import org.example.ecomproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
   @Autowired
   ProductService service;

    @GetMapping("/")
    public String greet(){
    return "Welcome to the Website!!";
}
   @GetMapping("/products")
   public ResponseEntity<List<Product>> getProducts(){
       return new ResponseEntity<>(service.getProducts(),HttpStatus.OK);
   }
   @GetMapping("/product/{prodId}")
   public ResponseEntity<Product> getProductById(@PathVariable int prodId){
      return new ResponseEntity<>(service.getProductById(prodId), HttpStatus.OK);
   }
   @PostMapping("/product")
   public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) throws IOException {
     try {
         Product product1 = service.addProduct(product, imageFile);
         return new ResponseEntity<>(product1,HttpStatus.CREATED);
     }
     catch(Exception e){
         return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
     }
   }
   @GetMapping("product/{id}/image")
   public ResponseEntity<byte[]> getProductImagebyId(@PathVariable int id){
        Product product = service.getProductById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(product.getImageData());
   }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,
                              @RequestPart Product product,@RequestPart(required = false) MultipartFile imageFile) throws IOException {

        if(product!=null) {
            service.updateProduct(id,product,imageFile);
            return new ResponseEntity<>("Product Updated Successfully", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Update Failed",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
       return new ResponseEntity<>("Product Deleted Successfully",HttpStatus.OK);
    }
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
        return new ResponseEntity<>(service.searchProducts(keyword),HttpStatus.OK);
    }
}
