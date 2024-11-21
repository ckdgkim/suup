package com.example.shopping_mall.productdomain.entity;

import com.example.shopping_mall.productdomain.exception.NoEnoughStockException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;
    @Enumerated(EnumType.STRING)
    private Warehouse warehouse;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    private long quantity;

    //편의 메서드 : 수량 증가(주문취소)/수량 감소(주문완료시)
    public void increaseStock(long quantity) {
        this.quantity += quantity;
    }

    public void decreaseStock(long quantity) {
        // 재고보다 주문량이 많으면 재고부족 exception 던지기
        if (this.quantity < quantity) {
            throw new NoEnoughStockException("재고가 부족합니다.");
        }
        this.quantity -= quantity;
    }
}
