package com.example.shopping_mall.productdomain.service;

import com.example.shopping_mall.productdomain.dto.ProductCreateDto;
import com.example.shopping_mall.productdomain.dto.ProductInquiryDto;
import com.example.shopping_mall.productdomain.entity.Product;
import com.example.shopping_mall.productdomain.entity.ProductStatus;
import com.example.shopping_mall.productdomain.exception.NotUniqueProductNameException;
import com.example.shopping_mall.productdomain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductInquiryDto addProduct(ProductCreateDto productDto) {
        if(checkUniqueProductName(productDto.getProductName())) {
            Product product = new Product(
              0,
              productDto.getProductName(),
              productDto.getCost(),
              productDto.getPrice(),
                    ProductStatus.active, LocalDate.now(),LocalDate.now()
            );
            productRepository.save(product);
            Product product1 = productRepository.findByProductName(productDto.getProductName()).get();
            return ProductInquiryDto.of(product1);
        }
        return null;
    }



    boolean checkUniqueProductName(String productName) {
        Optional<Product> byProductName = productRepository.findByProductName(productName);
        if (byProductName.isPresent()) {
            throw new NotUniqueProductNameException("이미 존재하는 제품명입니다.");
        }
        return true;
    }

    // 제품 조회 (ID로)
    public ProductInquiryDto getProductById(int productId) {
        Optional<Product> product = productRepository.findById((int) productId);
        return product.map(ProductInquiryDto::of).orElse(null);
    }

    // 모든 제품 조회
    public List<ProductInquiryDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductInquiryDto::of)
                .collect(Collectors.toList());
    }

    // 제품 상태 변경
    public ProductInquiryDto updateProductStatus(int productId, String status) {
        Optional<Product> product = productRepository.findById((int) productId);
        if (product.isPresent()) {
            Product p = product.get();
            p.changeStatus(ProductStatus.valueOf(status.toUpperCase())); // 상태 변경
            productRepository.save(p); // 상태 변경 후 저장
            return ProductInquiryDto.of(p); // 업데이트된 제품 정보 반환
        }
        return null;
    }

    // 제품 삭제
    public boolean deleteProduct(int productId) {
        Optional<Product> product = productRepository.findById((int) productId);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return true;
        }
        return false;
    }
}
