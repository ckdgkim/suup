package com.example.shopping_mall.productdomain.service;

import com.example.shopping_mall.productdomain.dto.ProductCreateDto;
import com.example.shopping_mall.productdomain.dto.ProductInquiryDto;
import com.example.shopping_mall.productdomain.dto.StockCreateDto;
import com.example.shopping_mall.productdomain.entity.Warehouse;
import com.example.shopping_mall.productdomain.exception.NotUniquestockException;
import com.example.shopping_mall.productdomain.repository.StockRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class StockServiceTest {
    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductService productService;

    @Test
    void 상품재고등록테스트() {
        // given
        ProductCreateDto productDto = new ProductCreateDto(
                "test1", 100, 120
        );
        ProductInquiryDto newProduct = productService.addProduct(productDto);

        StockCreateDto stockDto = new StockCreateDto(
                Warehouse.KR,
                newProduct.getProductId(),
                100);
        stockService.addStock(stockDto);
        Assertions.assertThat(stockRepository.findAll().size()).isEqualTo(1);

        StockCreateDto stockDto1 = new StockCreateDto(
                Warehouse.KR,
                newProduct.getProductId(),
                100);
        assertThrows(NotUniquestockException.class, () -> {
            stockService.addStock(stockDto1);
        });
    }
}