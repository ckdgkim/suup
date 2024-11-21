package com.example.shopping_mall.productdomain.repository;

import com.example.shopping_mall.productdomain.entity.Member;
import com.example.shopping_mall.productdomain.entity.Order;
import com.example.shopping_mall.productdomain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByMember(Member member);

    List<Order> findAllByMember(Member member);
}
