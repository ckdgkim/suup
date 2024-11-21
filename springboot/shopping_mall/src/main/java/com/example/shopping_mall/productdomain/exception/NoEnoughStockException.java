package com.example.shopping_mall.productdomain.exception;

public class NoEnoughStockException extends RuntimeException {
    public NoEnoughStockException() {
        super();
    }

    public NoEnoughStockException(String message) {
        super(message);
    }
}
