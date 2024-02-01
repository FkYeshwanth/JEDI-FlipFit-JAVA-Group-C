package com.flipkart.exception;
public class BookingExistsException extends Exception {
    public BookingExistsException(String message){
        super(message);
    }
}