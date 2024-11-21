package com.example.shopping_mall.productdomain.repository;

import com.example.shopping_mall.productdomain.entity.Delivery;
import com.example.shopping_mall.productdomain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
