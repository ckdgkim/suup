package com.example.shopping_mall.productdomain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(length = 20, unique = true)
    private String productName;
    @Column(nullable = false)
    private int cost;
    private int price;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    private LocalDate registrationDate;
    private LocalDate changeStatusDate;

    //가격 변경 불가
    //편의 메서드
    public void changeStatus(ProductStatus status) {
        this.status = status;
        this.changeStatusDate = LocalDate.now();

    }
}
