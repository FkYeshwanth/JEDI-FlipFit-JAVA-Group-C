package com.flipkart.exception;
public class NoPendingGymOwnerRequest extends Exception {
    public NoPendingGymOwnerRequest(String message){
        super(message);
    }
}