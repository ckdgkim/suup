package com.example.shopping_mall.productdomain.service;

import com.example.shopping_mall.productdomain.dto.ProductCreateDto;
import com.example.shopping_mall.productdomain.exception.NotUniqueProductNameException;
import com.example.shopping_mall.productdomain.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void 제품등록테스트(){
        // given
        ProductCreateDto productDto = new ProductCreateDto(
         "test1", 100, 120
        );
        ProductCreateDto productDto1 = new ProductCreateDto(
                "test1", 100, 120
        );
        // when
        productService.addProduct(productDto);
        Assertions.assertThat(productRepository.count()).isEqualTo(1);
        // then
        assertThrows(NotUniqueProductNameException.class, () -> {
            productService.addProduct(productDto1);
        });
    }
}