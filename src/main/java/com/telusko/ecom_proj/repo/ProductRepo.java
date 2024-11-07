package com.telusko.ecom_proj.repo;

import com.telusko.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT p from Product p WHERE "+" lower(p.name) LIKE lower(CONCAT('%', :keyword, '%')) or"
    + " lower(p.brand) like lower(concat('%', :keyword, '%')) or "
    +"lower(p.description) like lower(concat('%', :keyword, '%')) or"
    +" lower(p.category) like lower(concat('%', :keyword, '%'))")
    List<Product> searchProducts(String keyword);

}
