package com.flipkart.exception;
public class GymAlreadyExistsException extends Exception {
    public GymAlreadyExistsException(String message){
        super(message);
    }
}