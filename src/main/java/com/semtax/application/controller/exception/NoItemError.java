package com.semtax.application.controller.exception;

import java.util.NoSuchElementException;

public class NoItemError {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
