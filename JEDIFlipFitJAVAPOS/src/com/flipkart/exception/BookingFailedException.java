package com.flipkart.exception;

public class BookingFailedException extends Exception {
    public BookingFailedException(String message){
        super(message);
    }
}