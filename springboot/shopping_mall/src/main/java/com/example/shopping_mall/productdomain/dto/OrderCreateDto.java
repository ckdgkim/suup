package com.example.shopping_mall.productdomain.dto;


import com.example.shopping_mall.productdomain.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class OrderCreateDto {
    private int memberId;
    private String address;
}
