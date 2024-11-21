package com.example.shopping_mall.productdomain.exception;

public class NotUniqueUserException extends RuntimeException {
    public NotUniqueUserException() {
        super();
    }

    public NotUniqueUserException(String message) {
        super(message);
    }
}
