package com.example.shopping_mall.productdomain.dto;

import com.example.shopping_mall.productdomain.entity.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockCreateDto {
    private Warehouse warehouse;
    private int productId;
    private long quantity;
}
