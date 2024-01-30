package com.flipkart.exception;

public class SeatsNotavailableException extends Exception {
    public SeatsNotavailableException(String message){
        super(message);
    }
}