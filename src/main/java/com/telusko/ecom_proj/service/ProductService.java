package com.telusko.ecom_proj.service;

import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;
    
    public List<Product> getProducts() {
        return repo.findAll();
    }

//    public String addProduct(Product product, MultipartFile file) throws IOException {
//        product.setImageName(file.getOriginalFilename());
//        product.setImageType(file.getContentType());
//        try {
//            product.setImageData(file.getBytes());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        repo.save(product);
//        return "Product added";
//    }

    public ResponseEntity<String> addProduct(Product product)  {
        repo.save(product);
        return new ResponseEntity<>( "Product added", HttpStatus.OK);
    }

    public ResponseEntity< String> deleteProduct(int prodId) {
        if(repo.existsById(prodId) )
        {
            repo.deleteById(prodId);
            return new ResponseEntity<>("Product deleted", HttpStatus.OK);
        }
        else return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<String> updateProduct(Product product) {
       // repo.save(product);
        if(repo.existsById(product.getId()) )
        {
            repo.save(product);
            return new ResponseEntity<>( "Product updated", HttpStatus.OK);
        }
        else return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);

    }

    public List<Product> searchProducts(String keyWord) {
        System.out.println(keyWord+"service layer");
               return repo.searchProducts(keyWord);

    }

//    public ResponseEntity<?> uploadImage(MultipartFile file) {
//        repo.save()
//    }
}
