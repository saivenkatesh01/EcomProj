package com.telusko.ecom_proj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private BigDecimal price;
    private String description;
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "dd-MM-yyyy")
    private Date releaseDate;
    private boolean available;
    private int quantity;

//    private String imageName;
//    private String imageType;
//    @Lob
//    private byte[] imageData;

//    Insert into product(available, price, quantity, release_date, brand, category, description, name)
//    values(true,10000,300,'2024-02-01','Tata','cars','Comapct Suv','Nexon');

//    Insert into product(available, price, quantity, release_date, brand, category, description, name)
//    values(true,10000,300,'2024-02-01','Tata','cars','Comapct Suv','Nexon'),
//(true,10000,300,'2024-02-01','Tata','cars','Comapct Suv','Curvv'),
//        (true,10000,300,'2024-02-01','Tata','cars','Comapct Suv','Tigor'),
//        (true,10000,300,'2024-02-01','Hyundai','cars','Suv','Alcazar');
}
