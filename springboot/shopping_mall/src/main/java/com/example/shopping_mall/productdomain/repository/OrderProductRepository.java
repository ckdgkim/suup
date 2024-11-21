package com.example.shopping_mall.productdomain.repository;

import com.example.shopping_mall.productdomain.entity.Order;
import com.example.shopping_mall.productdomain.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
    List<OrderProduct> findAllByOrder(Order order);
}
