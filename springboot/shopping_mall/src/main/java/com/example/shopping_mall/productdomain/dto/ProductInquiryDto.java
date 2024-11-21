package com.example.shopping_mall.productdomain.dto;

import com.example.shopping_mall.productdomain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInquiryDto {
    private int productId;
    private String productName;
    private int price;

    public static ProductInquiryDto of(Product product) {
        ProductInquiryDto dto = new ProductInquiryDto(
                product.getProductId(),
                product.getProductName(),
                product.getPrice()
        );
        return dto;
    }
}
