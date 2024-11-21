package com.example.shopping_mall.productdomain.dto;

import com.example.shopping_mall.productdomain.entity.Member;
import com.example.shopping_mall.productdomain.entity.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateDto {
    @NotNull
    private String productName;
    @NotNull
    private Integer cost;
    @NotNull
    private Integer price;

}
