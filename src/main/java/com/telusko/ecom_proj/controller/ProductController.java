package com.telusko.ecom_proj.controller;

import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/")
    public String greet(){
        return "!! welcome";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);

    }

//    @PostMapping("/products")
//    public ResponseEntity<String> addProduct(@RequestPart Product product,
//                                            @RequestPart MultipartFile imageFile) throws IOException {
//        return new ResponseEntity<>(service.addProduct(product, imageFile), HttpStatus.OK);
//    }
    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody Product product)  {
        return service.addProduct(product);
    }

    @DeleteMapping("/products/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int prodId){
        return service.deleteProduct(prodId);
    }

    @PutMapping("/products")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @GetMapping("/products/search")
//    localhost:8080/api/products/search?keyWord="tata"    this is for @RequestParam syntax
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyWord){
        System.out.println(keyWord);
        List<Product> products= service.searchProducts(keyWord);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

//    public ResponseEntity<?> updateImage(@RequestParam MultipartFile file) {
//        return service.uploadImage(file);
//    }

}
