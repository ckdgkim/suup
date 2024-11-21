package com.example.shopping_mall.productdomain.controller;

import com.example.shopping_mall.productdomain.dto.ProductCreateDto;
import com.example.shopping_mall.productdomain.dto.ProductInquiryDto;
import com.example.shopping_mall.productdomain.entity.Product;
import com.example.shopping_mall.productdomain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products") // 기본 URL 경로를 설정합니다.
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 1. 제품 추가 (Create)
    @PostMapping
    public ResponseEntity<ProductInquiryDto> addProduct(@RequestBody ProductCreateDto productCreateDto) {
        ProductInquiryDto productInquiryDto = productService.addProduct(productCreateDto);
        if (productInquiryDto != null) {
            return new ResponseEntity<>(productInquiryDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 2. 제품 조회 (Read) - 특정 제품 조회
    @GetMapping("/{productId}")
    public ResponseEntity<ProductInquiryDto> getProductById(@PathVariable int productId) {
        ProductInquiryDto productInquiryDto = productService.getProductById(productId);
        return productInquiryDto != null ?
                new ResponseEntity<>(productInquiryDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 3. 모든 제품 조회
    @GetMapping
    public ResponseEntity<List<ProductInquiryDto>> getAllProducts() {
        List<ProductInquiryDto> productInquiryDtos = productService.getAllProducts();
        return new ResponseEntity<>(productInquiryDtos, HttpStatus.OK);
    }

    // 4. 제품 수정 (Update) - 상태 변경
    @PutMapping("/{productId}")
    public ResponseEntity<ProductInquiryDto> updateProductStatus(@PathVariable int productId,
                                                                 @RequestParam("status") String status) {
        ProductInquiryDto updatedProduct = productService.updateProductStatus(productId, status);
        return updatedProduct != null ?
                new ResponseEntity<>(updatedProduct, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 5. 제품 삭제 (Delete)
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        boolean isDeleted = productService.deleteProduct(productId);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
