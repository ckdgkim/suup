package com.example.shopping_mall.productdomain.service;

import com.example.shopping_mall.productdomain.dto.StockCreateDto;
import com.example.shopping_mall.productdomain.entity.Product;
import com.example.shopping_mall.productdomain.entity.Stock;
import com.example.shopping_mall.productdomain.entity.Warehouse;
import com.example.shopping_mall.productdomain.exception.NotUniquestockException;
import com.example.shopping_mall.productdomain.repository.ProductRepository;
import com.example.shopping_mall.productdomain.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    public int addStock(StockCreateDto stockDto) {
        Product product = productRepository.findById(stockDto.getProductId()).get();
        if (checkUniqueStock(Warehouse.KR, product)) {
            Stock stock = new Stock(
                    0,
                    Warehouse.KR,
                    product,
                    stockDto.getQuantity()
            );
            Stock save = stockRepository.save(stock);
            return save.getStockId();
        }
        return 0;
    }

    boolean checkUniqueStock(Warehouse warehouse, Product product) {
        Optional<Stock> byStock = stockRepository.findByWarehouseAndProduct(warehouse, product);
        if (byStock.isPresent()) {
            throw new NotUniquestockException("이미 재고자료가 존재합니다.");
        }
        return true;
    }
}
