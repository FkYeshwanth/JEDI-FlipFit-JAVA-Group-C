package com.flipkart.exception;
public class NoPendingGymRequest extends Exception {
    public NoPendingGymRequest(String message){
        super(message);
    }
}