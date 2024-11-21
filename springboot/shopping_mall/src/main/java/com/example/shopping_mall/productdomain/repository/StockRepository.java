package com.example.shopping_mall.productdomain.repository;

import com.example.shopping_mall.productdomain.entity.Product;
import com.example.shopping_mall.productdomain.entity.Stock;
import com.example.shopping_mall.productdomain.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Optional<Stock> findByWarehouseAndProduct(Warehouse warehouse, Product product);
}
