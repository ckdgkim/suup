package com.example.shopping_mall.productdomain.exception;

public class NotUniquestockException extends RuntimeException {
    public NotUniquestockException() {
        super();
    }

    public NotUniquestockException(String message) {
        super(message);
    }
}
