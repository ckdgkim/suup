package com.example.shopping_mall.productdomain.exception;

public class StockNotExistException extends RuntimeException {
    public StockNotExistException() {
        super();
    }

    public StockNotExistException(String message) {
        super(message);
    }
}
