package com.example.shopping_mall.productdomain.repository;

import com.example.shopping_mall.productdomain.entity.Member;
import com.example.shopping_mall.productdomain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByUserId(String userId);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByPhone(String phone);
}
