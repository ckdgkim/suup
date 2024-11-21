package com.example.shopping_mall.productdomain.exception;

public class OrderCancelException extends RuntimeException {
    public OrderCancelException() {
        super();
    }

    public OrderCancelException(String message) {
        super(message);
    }
}
