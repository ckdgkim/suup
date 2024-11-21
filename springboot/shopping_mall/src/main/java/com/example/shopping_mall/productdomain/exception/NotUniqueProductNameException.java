package com.example.shopping_mall.productdomain.exception;

public class NotUniqueProductNameException extends RuntimeException {
    public NotUniqueProductNameException() {
        super();
    }

    public NotUniqueProductNameException(String message) {
        super(message);
    }
}
