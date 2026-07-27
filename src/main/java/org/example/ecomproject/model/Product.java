package org.example.ecomproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@NoArgsConstructor
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodId;
    private String productName;
    private BigDecimal price;
    private String prodDesc;
    private String brand;
    private String category;
    private Date releaseDate;
    private boolean available;
    private int quantity;
}
